
package com.buddin.flooringmastery.dao;



import com.buddin.flooringmastery.dto.Order;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;


/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Interface that has the main behaviours of the dao
 */
public interface FlooringMasteryOrderDao {
    
     /* 
    * add an order 
    * date - in future
    * Customer Name - 
    * State - must exist in the tax file
    * Product Type 
    * Area positive and larger than 100sqft
    */
    
   
    // Get all orders for a specific date - takes date and returns all orders with that date
    Order getOrder (LocalDate orderDate, int OrderNum)
            throws FlooringMasteryDaoPersistenceException;
    
    // Method to get all the orders from a specific date
    List<Order> getAllOrders(LocalDate orderDate) 
            throws FlooringMasteryDaoPersistenceException;
    
  
    // Add another order
    Order addOrder(LocalDate orderDate, Order order)
            throws FlooringMasteryDaoPersistenceException,FileNotFoundException;
   

    // Remove an order - need to enter date and order number
    Order removeOrder(LocalDate orderDate, int orderNumber)
            throws FlooringMasteryDaoPersistenceException;
    
    // Saves the current sttte
    void saveOrder() 
            throws  FlooringMasteryDaoPersistenceException;

}
