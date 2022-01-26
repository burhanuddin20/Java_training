
package com.buddin.flooringmastery.service;

import com.buddin.flooringmastery.controller.FlooringMasteryController;
import com.buddin.flooringmastery.dao.FlooringMasteryAuditDao;
import com.buddin.flooringmastery.dao.FlooringMasteryAuditDaoFileImpl;
import com.buddin.flooringmastery.dao.FlooringMasteryOrderDao;
import com.buddin.flooringmastery.dao.FlooringMasteryOrderDaoStub;
import com.buddin.flooringmastery.dao.FlooringMasteryProductDaoStub;
import com.buddin.flooringmastery.dao.FlooringMasteryProductsDao;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxDao;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxDaoStub;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author burhan
 */


public class FlooringMasteryServiceLayerImplTest {
    
     private FlooringMasteryServiceLayer service;
    
    public FlooringMasteryServiceLayerImplTest() {
        
       

        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        service = ctx.getBean("flooringMasteryServiceLayerImpl", FlooringMasteryServiceLayer.class);
        // initialise the service w/ the stubs
        
    
    }
    
    
        @BeforeEach
        public void setUp() throws Exception {
        // everytime this test runs create a new products test file
        // initiate a new daoFileImpl with that test file
        
            
    }
    
    
     @Test
    public void testGetOrdersByDate() throws Exception {
        LocalDate ld = LocalDate.parse("2000-01-01");
        List<Order> orderList = new ArrayList();
        orderList = service.getOrdersForDate(ld);

        assertEquals(2, orderList.size());

    }
    
        @Test
    public void testCreateOrder() throws Exception {
        LocalDate testDate = LocalDate.parse("2000-01-01");
        Order testOrder = new Order();

        //Create testorder
        testOrder.setOrderNumber(57);
        testOrder.setCustomerName("Joe");
        // get a list of all 
        Tax testTax = new Tax();

        testTax.setStateAbbreviation("WA");
        testOrder.setTaxObj(testTax);
        
        Product testProduct = new Product();
        testProduct.setProductType("Wood");
        testOrder.setProduct(testProduct);

        testOrder.setArea(new BigDecimal("175"));
        
        
         service.createOrder(testDate, testOrder);

        List<Order> orderList = service.getOrdersForDate(testDate);
        

        assertEquals(3, orderList.size());
            assertEquals(orderList.get(0).getCustomerName(), "Joe","Customer should be Joe");
    }
    
 
    @Test
    public void testRemoveOrder() throws Exception {
        LocalDate testDate = LocalDate.parse("2000-01-01");

        service.removeOrder(testDate, 57);

        List<Order> orderList = service.getOrdersForDate(testDate);

        assertEquals(2, orderList.size());
    }

    
}
