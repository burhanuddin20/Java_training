
package com.buddin.flooringmastery.dao;


import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: CRUD methods for the Order DAO
 */

@Component
public class FlooringMasteryOrderDaoFileImpl implements FlooringMasteryOrderDao {


    // 2 hash maps
    // First is where the date is the key and values are a map of the orders for that data
    // 2nd - orderno = key and values are the orders
    private Map<LocalDate, Map<Integer,Order>> ordersByDate = new HashMap<>();
    // text file
    private  String orderFile = "Orders_";
    // delimiter
    public static final String DELIMITER = ",";
    // order date
    public LocalDate ordersDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

    // Need to define which date file to read/write from
    
    
    
      // Add a new order
    @Override
        public Order addOrder(LocalDate orderDate, Order order) throws FlooringMasteryDaoPersistenceException,FileNotFoundException,NullPointerException {
            
        // Need to check if a date file for the order exits
        // check the list of dates
        
        // check if the date exists
        Map<Integer,Order> ordersForDate = new HashMap<>();
        this.ordersDate = orderDate;
        
        try {
            loadOrders();
            
            //ordersByDate.get(orderDate);
            // Not copying data properly for some reason
            System.out.println(ordersByDate.get(ordersDate));
            ordersForDate.putAll(ordersByDate.get(ordersDate));
          
            
            
        } catch (FlooringMasteryDaoPersistenceException | NullPointerException e) {
        }

        // If the order Number does not exist, try to create one
        if (order.getOrderNumber() == 0) {
            try {
                order.setOrderNumber(generateOrderNum(orderDate));
                
            } catch (FileNotFoundException e) {
                order.setOrderNumber(1);
            }
           
        }

        Order newOrder = ordersForDate.put(order.getOrderNumber(), order);
        ordersByDate.put(orderDate, ordersForDate);
        
      
        writeOrder();
        return newOrder;        

    }

    
    
   

    // return a specific order for a specific date
    @Override
    public Order getOrder(LocalDate orderDate,int orderNum) throws FlooringMasteryDaoPersistenceException {
        
        this.ordersDate = orderDate;
        Order returnedOrder = ordersByDate.get(ordersDate).get(orderNum);
        return returnedOrder;
        

    }

    
    // Get all orders for a particular date
    @Override
    public List<Order> getAllOrders(LocalDate orderDate) throws FlooringMasteryDaoPersistenceException {
            this.ordersDate = orderDate;
            
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
        this.ordersDate = ordersDate;
        Order removedOrder = ordersByDate.get(ordersDate).remove(orderNumber);
        writeOrder();
        return removedOrder;

    }
    
    
    
    
    
    
    
    // Methods to read/write to the order files
    
    private int generateOrderNum(LocalDate orderDate) throws FlooringMasteryDaoPersistenceException,NoSuchElementException, FileNotFoundException{
    
        Scanner scanner;
        int orderNum = 1;
        // check this file for lines to get the order number
        String orderFileFullName = orderFile + orderDate.format(formatter)+".txt";
        
         try {
            // Create Scanner for reading the file
             try{
                  scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(orderFileFullName)));
             }    
            catch(FileNotFoundException e){
                throw new FileNotFoundException("Order file does not exist ------ CREATING NEW FILE");
             }
           
            int count = 0;
             while (( scanner.nextLine()) != null) {
                 orderNum++;
                 
             }
        }
         
         catch (NoSuchElementException e) {
         }return orderNum;
         
    
         

    
    }
    
    
    
    
    // For both of these methods need to do something about the r/w headers
      
      // Method to unmarshall the product data from the product file
     private Order unmarshallOrder(String orderAsText){
        // store the different parts to the array
        String[]ordertokens = orderAsText.split(DELIMITER);
        // file in the form of id::name::price::stock

        // Order id first thing in array
        int orderNum  = Integer.parseInt(ordertokens[0]);
         
        
       
        // create a new order object using the id
       Order orderFromFile = new Order(orderNum);
       orderFromFile.setOrderDate(ordersDate);
       // set all the other fields
       // set the customer name
       orderFromFile.setCustomerName(ordertokens[1]);
       
       // set the tax fields to a new tax object for the current order
       Tax orderFromFileTax = new Tax();
       // set the state abbreviation
       orderFromFileTax.setStateAbbreviation(ordertokens[2]);
       // set the tax rate
       orderFromFileTax.setTaxRate(new BigDecimal(ordertokens[3]));
       
       orderFromFile.setTaxObj(orderFromFileTax);
      
        // set the product fields to a new product object for the current order
       Product orderFromFileProduct = new Product();
       
       // set the product type
       orderFromFileProduct.setProductType(ordertokens[4]);
       
       // set the area
       orderFromFile.setArea(new BigDecimal(ordertokens[5]));
       
       // set the costpersqft
       orderFromFileProduct.setCostPerSquareFoot(new BigDecimal(ordertokens[6]));
       // set the labour per sq ft
       orderFromFileProduct.setLabourCostPerSquareFoot(new BigDecimal(ordertokens[7]));
       
       
       orderFromFile.setProduct(orderFromFileProduct);
       
       //set the material cost
       orderFromFile.setMaterialCost();
       //set the labour cost
       orderFromFile.setLabourCost();
       
       // set the tax total
       orderFromFile.setTaxTotal();
       orderFromFile.setTotalCost();
       
       
       
       
        // return the complete item obj
        return orderFromFile;
    }
    
    
     
     
     // Method to read the product  file
     // Will have to do something about the header file at the top
     private void loadOrders() throws FlooringMasteryDaoPersistenceException {
        Scanner scanner;
        
        // set the full name of the file -- Orders_MMddyyyy.txt
        String orderFileFullName  = orderFile + ordersDate.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
        
        // stores just the orders with order id as key
        Map<Integer,Order> ordersForDate = new HashMap<>();
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(orderFileFullName)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoPersistenceException(
                    "!!!Could not loadOrders order data into memory!!!", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTax holds the most recent product unmarshalled
        Order currentOrder;
        
        // Go through Order line by line, decoding each line into an order object
        // Via the unmarshall order method
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into an Item
            currentOrder = unmarshallOrder(currentLine);

            // put the current order into the orders hash map
            ordersForDate.put(currentOrder.getOrderNumber(), currentOrder);
            // store the orders hashmap using the orderdate as key
            ordersByDate.put(ordersDate, ordersForDate);
        }
        // close scanner
        scanner.close();
    }
     
     
     
     
     
      // Method to marshall the order object and fields to a csv format
     private String marshallOrder(Order order){
        
        // Turn the order object into a text line for storing
        // OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total

        // Start with the orderNumber 
        String orderAsString = order.getOrderNumber()+ DELIMITER;

 
        // Customer Name
        orderAsString += order.getCustomerName()+ DELIMITER;

        // state
        orderAsString += order.getStateAbbreviation()+ DELIMITER;
        
         // taxrate
        orderAsString += order.getTaxRate()+ DELIMITER;
        
        // productType
        orderAsString += order.getProductType()+ DELIMITER;
        
        // Area
        orderAsString += order.getArea()+ DELIMITER;
        
        // cost per sq ft
        orderAsString += order.getProduct().getCostPerSquareFoot()+ DELIMITER;
        
        // labour per sq ft
        orderAsString += order.getProduct().getLabourCostPerSquareFoot()+ DELIMITER;
        
        // Material cost
        orderAsString += order.getMaterialCost()+ DELIMITER;
        
        // Labour cost
        orderAsString += order.getLabourCost()+ DELIMITER;
        
         // Tax total, does not work if tax total is not set
        orderAsString += order.getTaxTotal()+ DELIMITER;
        
         // Total cost
        orderAsString += order.getTotalCost();


        

        // return the line of text
        return orderAsString;
    }
     
     
     
     
     
     
     //Method to write to a new order file
     // Need to add a header file to the top
     private void writeOrder() throws FlooringMasteryDaoPersistenceException {
            PrintWriter out;
            String orderFileFullName;

            // get a list of all the date files
            List<LocalDate> dateFiles = new ArrayList<>(ordersByDate.keySet());

            // iterate over all of the date files  
            for (LocalDate  currentFile: dateFiles) {

                 // format the file name to MMddyyyy
                 
                 orderFileFullName = orderFile + currentFile.format(formatter)+".txt";

                try {
                    out = new PrintWriter(new FileWriter(orderFileFullName));
                } catch (IOException e) {
                        throw new FlooringMasteryDaoPersistenceException(
                        "Could not save the order data.", e);
                }


            // Write to each date file
           // Get a list of all the orders for the current date iteration 
            List<Order> allOrders = new ArrayList<>(ordersByDate.get(currentFile).values());
                
            for (Order currentOrder : allOrders) {
                // turn the item into a String
                // error is in marshall part
                String orderAsString = marshallOrder(currentOrder);
                // write the product object to the file
                out.println(orderAsString);
                // force PrintWriter to write line to the file
                out.flush();
            }
            // Clean up
            out.close();
        }   


    }
     
     
     // Save the order method
    @Override
    public void saveOrder() throws FlooringMasteryDaoPersistenceException {
        writeOrder();
    }
}
