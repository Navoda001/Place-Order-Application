/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;


import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.OrderDetailDto;
import edu.ijse.mvc.dto.OrderDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class OrderModel {
    
    private Connection connection;
    
    public OrderModel() throws ClassNotFoundException,SQLException{
        connection = DBConnection.getInstance().getConnection();
        
    }
    
    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws SQLException{
        
        try {
            connection.setAutoCommit(false);
            
            String orderSql = "INSERT INTO Orders VALUES(?,?,?)";
            PreparedStatement orderStatement= connection.prepareStatement(orderSql);
            orderStatement.setString(1,orderDto.getOrderId() );
             orderStatement.setString(2,orderDto.getDate());            
            orderStatement.setString(3,orderDto.getCustId());
            
            boolean isOrderSaved = orderStatement.executeUpdate() > 0;
            
            if(isOrderSaved){
                boolean isOrderDeetailsSaved =true;
                
                String orderDetailSql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderDetailStatement = connection.prepareStatement(orderDetailSql);
                    orderDetailStatement.setString(1, orderDto.getOrderId());
                    orderDetailStatement.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatement.setInt(3,orderDetailDto.getQty());
                    orderDetailStatement.setInt(4, orderDetailDto.getDiscount());
               
                    if(!(orderDetailStatement.executeUpdate () > 0)){
                         isOrderDeetailsSaved = false;
                    } 
                }
                if(isOrderDeetailsSaved){
                    boolean isItemUpdated = true;
                    
                    String itemUpdateSql = "UPDATE item Set QtyOnHand = QtyOnHand - ? WHERE ItemCode = ?";
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement itemStatement = connection.prepareStatement(itemUpdateSql);
                    itemStatement.setInt(1,orderDetailDto.getQty());
                    itemStatement.setString(2, orderDetailDto.getItemCode());
                    
               
                    if(!(itemStatement.executeUpdate () > 0)){
                         isOrderDeetailsSaved = false;
                    }   
                }
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                    return "Item Update Error";
                    }
                    
                }else{
                    connection.rollback();
                    return "Order Details Save Error";
                }
                
            }else{
                connection.rollback();
                return "Order Save Error";
            }
            
            
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        }finally{
            connection.setAutoCommit(true);
        }
    }
}
