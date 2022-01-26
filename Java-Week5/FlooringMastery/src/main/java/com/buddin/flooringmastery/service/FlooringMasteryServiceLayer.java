package com.buddin.flooringmastery.service;

import com.buddin.flooringmastery.dao.FlooringMasteryDaoPersistenceException;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxException;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import java.io.FileNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface FlooringMasteryServiceLayer {
    
    
    // create a new order
    Order createOrder(LocalDate orderDate, Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException;
    
    // Get a list of orders for a date 
    List<Order> getOrdersForDate(LocalDate orderDate) throws FlooringMasteryDaoPersistenceException;
    
   
    // edit a specific order for a specific date
    Order editOrder(Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException;
    
    
    // get the tax info for a state
    Tax getTax(String stateAbbreviation) throws FlooringMasteryDaoPersistenceException,FlooringMasteryTaxException;
  
    // Get a list of all the tax infor
    List<Tax> getAllTaxes() throws FlooringMasteryDaoPersistenceException;
   
    // Get a single order
    Order getSingleOrder(LocalDate orderDate, int orderNum) throws FlooringMasteryDaoPersistenceException;
   
    // remove an order
    Order removeOrder(LocalDate orderDate, Integer orderID) throws FlooringMasteryDaoPersistenceException;
    
    // get a list of all the products
    List<Product> getAllProducts() throws FlooringMasteryDaoPersistenceException;
    
    // return a single product
    Product getAProduct(String productType) throws FlooringMasteryDaoPersistenceException,FlooringMasteryTaxException;
    
    // save the current order
    


    void saveOrder(Order order) throws FlooringMasteryDaoPersistenceException, FileNotFoundException;

    void exportData() throws FlooringMasteryDaoPersistenceException;

    ;
    
    

}
