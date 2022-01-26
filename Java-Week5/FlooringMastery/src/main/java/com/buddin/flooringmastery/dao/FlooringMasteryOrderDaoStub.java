
package com.buddin.flooringmastery.dao;

import static com.buddin.flooringmastery.dao.FlooringMasteryOrderDaoFileImpl.DELIMITER;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Test data for the order tests
 */

public class FlooringMasteryOrderDaoStub implements FlooringMasteryOrderDao{
    
    public LocalDate orderDate;
    int orderNum = 100;
    
    private Map<LocalDate, Map<Integer,Order>> ordersByDate = new HashMap<>();

   // Add a new order
    @Override
        public Order addOrder(LocalDate orderDate, Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException,NullPointerException {
            
        // Need to check if a date file for the order exits
        // check the list of dates
        
        // check if the date exists
        Map<Integer,Order> ordersForDate = new HashMap<>();
        this.orderDate = orderDate;
        
        try {
            loadOrders();
            
            //ordersByDate.get(orderDate);
            ordersForDate.putAll(ordersByDate.get(orderDate));
          
            
            
        } catch (FlooringMasteryDaoPersistenceException | NullPointerException e) {
        }
        
        //If the order Number does not exist, try to create one
        if (order.getOrderNumber() == 0) {
          
             order.setOrderNumber(generateOrderNum());
                
            
           
        }
        
        ordersForDate.put(order.getOrderNumber(), order);
        ordersByDate.put(orderDate, ordersForDate);
        
      
     
        return order;        

    }

    
    
   

    // return a spefcific order for a specific date
    @Override
    public Order getOrder(LocalDate orderDate,int orderNum) throws FlooringMasteryDaoPersistenceException {
        
        this.orderDate = orderDate;
        Order returnedOrder = ordersByDate.get(orderDate).get(orderNum);
        return returnedOrder;
        

    }

    
    // Get all orders for a particular date
    @Override
    public List<Order> getAllOrders(LocalDate orderDate) throws FlooringMasteryDaoPersistenceException {
            this.orderDate = orderDate;
            
            // if false - ordersByDate does not contain the orderDate
            if(!ordersByDate.containsKey(orderDate)){
                loadOrders();// get an error here for some reason
            }
            
            return new ArrayList<>(ordersByDate.get(orderDate).values());
    }

    
  
    

    
    // Remove an entry from the orders for a specific date file
    @Override
    public Order removeOrder(LocalDate orderDate, int orderNumber) throws FlooringMasteryDaoPersistenceException {
        
        loadOrders();
        this.orderDate = orderDate;
        if (ordersByDate.get(orderDate).containsKey(orderNumber)) {
           return ordersByDate.get(orderDate).remove(orderNumber);
        }
        else return null;
    

    }
    
    
    
    
    
    
    
    // Methods to read/write to the order files
    
    private int generateOrderNum() throws FlooringMasteryDaoPersistenceException,NoSuchElementException, FileNotFoundException{
    
        orderNum +=1;
         
    
         
        return orderNum;
    
    }
    
    
    
    
    
     
     
     // Method to read the product  file
     // Will have to do something about the header file at the top
     private void loadOrders() throws FlooringMasteryDaoPersistenceException {
       
       Map<Integer,Order> testOrders = new HashMap<>();
        
       LocalDate testDate = LocalDate.parse("2000-01-01");
        
        //Order1
        Order order1 = new Order(50);
        order1.setCustomerName("Doctor Who");
        order1.setArea(new BigDecimal("243.00"));
        
        Tax testTax1 = new Tax("WA");
        order1.setTaxObj(testTax1);
     
        testTax1.setStateName("Washington");
        testTax1.setTaxRate(new BigDecimal("9.25"));
       
        Product testProduct1 = new Product("Wood");
        order1.setProduct(testProduct1);
        order1.setArea(new BigDecimal("243.00"));
        order1.setCostPerSquareFoot(new BigDecimal("5.15"));
        order1.setLabourCostPerSquareFoot(new BigDecimal("4.75"));
        order1.setLabourCost();
        order1.setMaterialCost();
        order1.setTaxTotal();
        order1.setTotalCost();
        order1.setOrderDate(testDate);
        
        Order order2 = new Order(51);
        order2.setCustomerName("Albert Einstein");
        
        Tax testTax2 = new Tax("KY");
        order2.setTaxObj(testTax2);
        
        testTax2.setTaxRate(new BigDecimal("6.25"));
        testTax2.setStateName("Kentucky");
        Product testProduct2 = new Product("Carpet");
        order2.setProduct(testProduct2);
        order2.setArea(new BigDecimal("217.00"));
        order2.setCostPerSquareFoot(new BigDecimal("2.25"));
        order2.setLabourCostPerSquareFoot(new BigDecimal("2.10"));
        order2.setMaterialCost();
        order2.setLabourCost();
        order2.setTaxTotal();
        order2.setTotalCost();
        order2.setOrderDate(testDate);


        // Store both orders
        testOrders.put(order1.getOrderNumber(), order1);
        ordersByDate.put(testDate, testOrders);
        testOrders.put(order2.getOrderNumber(), order2);
        ordersByDate.put(testDate, testOrders);

        
    }
     
     
     

     
     // Save the order method
    @Override
    public void saveOrder() throws FlooringMasteryDaoPersistenceException {
      
    }

}
