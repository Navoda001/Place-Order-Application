/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;


import edu.ijse.mvc.model.CustomerModel;
import edu.ijse.mvc.dto.CustomerDto;

/**
 *
 * @author Navoda Chathurya
 */
public class CustomerController {
    private CustomerModel customerModel = new CustomerModel();
    
    public CustomerDto searchItem(String custId)throws Exception{
        return customerModel.getCustomer(custId);
    }
}
