/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;


import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.CustomerDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Navoda Chathurya
 */
public class CustomerModel {
    
    private final Connection connection;
    
    public CustomerModel () throws ClassNotFoundException, SQLException{
        this.connection=DBConnection.getInstance().getConnection();
    }
    
     public CustomerDto getCustomer(String custId) throws Exception {
        String sql = "SELECT * FROM Customer WHERE CustID = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, custId);
        
        ResultSet rst = statement.executeQuery();
        
        if (rst.next()) {            
            CustomerDto dto = new CustomerDto(
                    rst.getString("CustID"), rst.getString("CustTitle"),
                    rst.getString("CustName"), rst.getString("DOB"),
                    rst.getDouble("salary"), rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"), rst.getString("PostalCode"));
            return dto;
        }
        return null;
    }
}
