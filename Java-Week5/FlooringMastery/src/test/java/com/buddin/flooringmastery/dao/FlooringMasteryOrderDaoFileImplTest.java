
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class FlooringMasteryOrderDaoFileImplTest {
    
     FlooringMasteryOrderDao testOrderDao = new FlooringMasteryOrderDaoFileImpl();
    
    
    public FlooringMasteryOrderDaoFileImplTest() {
    }
    
        
    /*
    Test Plan
    Order 1: 2,Doctor Who,WA,9.25,Wood,243.00,5.15,4.75,1251.45,1154.25,216.51,2622.21
    Order 2: 3,Albert Einstein,KY,6.00,Carpet,217.00,2.25,2.10,488.25,455.70,56.64,1000.59
    
    */

    @Test
    public void testAddGetOrder() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        //Arrange
        Order order1 = new Order(1);
        order1.setCustomerName("Doctor Who");
        order1.setArea(new BigDecimal("243.00"));
        
        Tax testTax = new Tax("WA");
        order1.setTaxObj(testTax);
        
        order1.setStateName("Washington");
        order1.setTaxRate(new BigDecimal("9.25"));
        
       
        Product testProduct = new Product("Wood");
        order1.setProduct(testProduct);
        order1.setArea(new BigDecimal("243.00"));
        order1.setCostPerSquareFoot(new BigDecimal("5.15"));
        order1.setLabourCostPerSquareFoot(new BigDecimal("4.75"));
        order1.setLabourCost();
        order1.setMaterialCost();
        order1.setTaxTotal();
        order1.setTotalCost();
        order1.setOrderDate(LocalDate.parse("03/05/2006",formatter));
      
  
        //Act
        testOrderDao.addOrder(order1.getOrderDate(), order1);
        Order retrievedOrder = testOrderDao.getOrder(order1.getOrderDate(), order1.getOrderNumber());
        
        
        //Assert
        
        assertNotNull(retrievedOrder,"Should not be null");
        assertEquals("Doctor Who", retrievedOrder.getCustomerName(),"Customer names are not equal");
        assertEquals(new BigDecimal("243.00"),retrievedOrder.getArea(),"Area do not match");
        assertEquals("WA", retrievedOrder.getStateAbbreviation(),"State do not match");
        assertEquals("Washington", retrievedOrder.getStateName(),"State names do not match");
        assertEquals(new BigDecimal("9.25"), retrievedOrder.getTaxRate(),"Tax rates do not match");
        assertEquals("Wood", retrievedOrder.getProductType(),"product types do not match");
        
        
    }
    
    
    
     /*
    Test Plan
    Order 1: 2,Doctor Who,WA,9.25,Wood,243.00,5.15,4.75,1251.45,1154.25,216.51,2622.21
    Order 2: 3,Albert Einstein,KY,6.00,Carpet,217.00,2.25,2.10,488.25,455.70,56.64,1000.59
    */
    

    @Test
    public void testGetAllOrders()throws Exception{
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        //Arrange
        Order order1 = new Order(1);
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
        order1.setOrderDate(LocalDate.parse("03/05/2006",formatter));
        
        Order order2 = new Order(2);
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
        order2.setOrderDate(LocalDate.parse("03/05/2006", formatter));
        
        
        //Act
        testOrderDao.addOrder(order1.getOrderDate(), order1);
        testOrderDao.addOrder(order2.getOrderDate(), order2);
        
        List<Order> testOrders = testOrderDao.getAllOrders(LocalDate.parse("03/05/2006", formatter));
        
        
        //Assert
        assertEquals(2,testOrders.size(), "Should have 2 orders");
        
        
        assertTrue(testOrders.contains(order2),
                "Should have Order 2.");
        
        // cannot assert this one because it creates a new order object
        assertEquals(testOrders.get(0).getOrderNumber(),(int) 1,"Should have Ordernum 1");
         
  
    
    
    
    }
    

    
    
    /*
    Test Plan
    Order 1: 2,Doctor Who,WA,9.25,Wood,243.00,5.15,4.75,1251.45,1154.25,216.51,2622.21
    Order 2: 3,Albert Einstein,KY,6.00,Carpet,217.00,2.25,2.10,488.25,455.70,56.64,1000.59
    Should remove order1 
    
    */
    
    @Test
    public void testRemoveOrder() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        //Arrange
        Order order1 = new Order(1);
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
        order1.setOrderDate(LocalDate.parse("03/05/2006",formatter));
        
        Order order2 = new Order(2);
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
        order2.setOrderDate(LocalDate.parse("03/05/2006", formatter));
        
        
        //Act
        testOrderDao.addOrder(order1.getOrderDate(), order1);
        testOrderDao.addOrder(order2.getOrderDate(), order2);
        testOrderDao.removeOrder(order1.getOrderDate(), order1.getOrderNumber());
        
         List<Order>  allOrders = testOrderDao.getAllOrders(order2.getOrderDate()); 
         System.out.println(Arrays.toString(allOrders.toArray()));
       
        // First check the general contents of the list
        assertNotNull(allOrders, "The list of orders must not null");
        assertEquals(1, allOrders.size(),"List of products should have 1 products.");

        // Then the specifics
        
       assertFalse(testOrderDao.getAllOrders(order2.getOrderDate()).contains(order1),
                "Should not have order1.");
      
        
   
        
    }
    
    
}
