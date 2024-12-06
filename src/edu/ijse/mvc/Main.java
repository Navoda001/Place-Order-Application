/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ijse.mvc;
import edu.ijse.mvc.view.ItemView;
import edu.ijse.mvc.view.OrderView;
/**
 *
 * @author Navoda Chathurya
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       new ItemView().setVisible(true);
        new OrderView().setVisible(true);                    
    }
    
}
