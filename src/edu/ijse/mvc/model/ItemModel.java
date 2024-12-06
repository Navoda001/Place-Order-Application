/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Navoda Chathurya
 */
public class ItemModel {
    public String saveItem(ItemDto itemDto) throws Exception{
        String sql = "INSERT INTO item VALUES (?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getCode());
        statement.setString(2, itemDto.getDescription());
        statement.setString(3, itemDto.getPackSize());
        statement.setDouble(4, itemDto.getUntPrice());
        statement.setInt(5, itemDto.getQoh());
        
        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    
    public String updateItem(ItemDto itemDto) throws Exception{
        String sql = "UPDATE item SET Description = ?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPackSize());
        statement.setDouble(3, itemDto.getUntPrice());
        statement.setInt(4, itemDto.getQoh());
        statement.setString(5, itemDto.getCode());
        
        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    
    public String deleteItem(String code) throws Exception{
        String sql = "DELETE from item WHERE ItemCode=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, code);
        
        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }
    
    public ItemDto searchItem(String code) throws Exception{
        String sql = "SELECT * from item WHERE ItemCode=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, code);
        
        ResultSet rst = statement.executeQuery();
        if(rst.next()){
            ItemDto dto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
            return dto;
        }
        return null;
    }
    
    public ArrayList<ItemDto> getAllItem() throws Exception{
        String sql = "SELECT * from item";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        while(rst.next()){
            ItemDto dto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
            itemDtos.add(dto);
        }
        return itemDtos;
    }
}