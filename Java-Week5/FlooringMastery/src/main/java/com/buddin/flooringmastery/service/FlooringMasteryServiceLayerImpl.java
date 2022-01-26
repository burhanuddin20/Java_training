
package com.buddin.flooringmastery.service;

import com.buddin.flooringmastery.dao.FlooringMasteryAuditDao;
import com.buddin.flooringmastery.dao.FlooringMasteryDaoPersistenceException;


import java.math.RoundingMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.buddin.flooringmastery.dao.FlooringMasteryOrderDao;
import com.buddin.flooringmastery.dao.FlooringMasteryProductsDao;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxDao;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxException;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Implements all the  dao implementations to get functionality and business logic
 */
@Component
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {
    
    // initialise all the daos
    FlooringMasteryOrderDao orderDao;
    FlooringMasteryTaxDao taxDao;
    FlooringMasteryProductsDao productDao;
    
    private FlooringMasteryAuditDao auditDao;
    
    // use a constructor to set them up
    @Autowired
    public FlooringMasteryServiceLayerImpl(FlooringMasteryOrderDao orderDao,FlooringMasteryTaxDao taxDao,FlooringMasteryProductsDao productDao, FlooringMasteryAuditDao auditDao){
    
        this.orderDao = orderDao;
        this.taxDao = taxDao;
        this.productDao = productDao;
        this.auditDao = auditDao;
    
    }


    
    @Override
    public Order createOrder(LocalDate orderDate, Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException {
       
        // create a new order with all the info

        Order newOrder = order;
        try {


            Tax retrievedTax = getTax(order.getStateAbbreviation());// get the tax state from the user input - will throw an exception if state is not in list
            order.setTaxObj(retrievedTax);// set the tax object as a property of the order object

            Product retrievedProduct = getAProduct(order.getProductType());// get a prodcut and check if it is valid
            order.setProduct(retrievedProduct);
            // set all the calculable fields
            order.setLabourCost();
            order.setMaterialCost();
            order.setTaxTotal();
            order.setTotalCost();

        } catch (FlooringMasteryTaxException ex) {

        }

        
        order.setOrderDate(orderDate);// set the order date

        auditDao.writeAuditEntry(// write to audit if succesful
                "Order date " + orderDate+ "-- Order Number"+order.getOrderNumber()+ " CREATED.");


        return newOrder;
    }

    
    // returns a list of orders for a specified date using the order dao
    @Override
    public List<Order> getOrdersForDate(LocalDate orderDate) throws FlooringMasteryDaoPersistenceException {
        // new list of orders for the specified order date
        // call on dao with getAllOrders method 
        List<Order> ordersForDate = orderDao.getAllOrders(orderDate);
        return ordersForDate; // return the list

    }

    // returns an edited order
    @Override
    public Order editOrder(Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException {
       
        // remove the info for the order first
        orderDao.removeOrder(order.getOrderDate(), order.getOrderNumber());
        // set the new info for the order now
        
        Order editedOrder = createOrder(order.getOrderDate(),order);

        return editedOrder;

    }
    
    
    // removes an order from a specific date
     @Override
    public Order removeOrder(LocalDate orderDate, Integer orderID) throws FlooringMasteryDaoPersistenceException {
        
        
        // call the dao method
        Order removedOrder = orderDao.removeOrder(orderDate, orderID);
        return removedOrder;
    }
    
    
    
    
    
    // return a certain state from the tax class
    // use the state abbreviation
    
    @Override
    public Tax getTax(String stateAbbreviation) throws FlooringMasteryTaxException, FlooringMasteryDaoPersistenceException {
        
        
        Tax retrievedTax = taxDao.getState(stateAbbreviation);
        if (retrievedTax == null) {
            throw new FlooringMasteryTaxException("Do not work in that state!");        
        }
    // use getState method
       return retrievedTax;
    }
    

    // return a list of all states in the tax class
    @Override
    public List<Tax> getAllTaxes() throws FlooringMasteryDaoPersistenceException {
        // use taxdao method of getallstates
        List<Tax> allTaxes = taxDao.getAllStates();
        return  allTaxes;
        
    }

    
    
    // return a single order from a specific date
    @Override
    public Order getSingleOrder(LocalDate orderDate, int orderNum) throws FlooringMasteryDaoPersistenceException {
            
         Order returnedOrder = orderDao.getOrder(orderDate, orderNum);
         return returnedOrder;
    }

   
    // return a list of all the products
    @Override
    public List<Product> getAllProducts() throws FlooringMasteryDaoPersistenceException {
        // use the product dao method
        List<Product> allProducts = productDao.getAllproducts();
        return allProducts;
    }
    
    
    // get a single product type 
    @Override
    public Product getAProduct(String productType) throws FlooringMasteryDaoPersistenceException {
        if (productDao.getproduct(productType) == null) {
            throw new FlooringMasteryDaoPersistenceException("");
            
        }
        Product retrievedProduct = productDao.getproduct(productType); // gets the prodcut from the product dao
        return retrievedProduct;
    }



    @Override
    public void saveOrder(Order order) throws FlooringMasteryDaoPersistenceException, FileNotFoundException {
        // save the order
        orderDao.addOrder(order.getOrderDate(), order);
        orderDao.saveOrder();
                
    }

    @Override
    public void exportData() throws FlooringMasteryDaoPersistenceException{
        orderDao.saveOrder();
    }







}



