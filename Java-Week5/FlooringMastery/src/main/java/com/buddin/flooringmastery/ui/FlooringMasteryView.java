
package com.buddin.flooringmastery.ui;

import com.buddin.flooringmastery.dao.FlooringMasteryInputException;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: All the message and input methods to the user
 */

@Component
public class FlooringMasteryView {

    // new instance of the user io
    private UserIO io;

    //constructor
    @Autowired
    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

     // All output/input from here

    // print the menu selection
    public int printMenuAndGetSelection() {
        io.print("************************************");
        io.print("<<Flooring Program>>");
        io.print("*1. Display Orders");
        io.print("*2. Add an Order");
        io.print("*3. Edit and Order");
        io.print("*4. Remove an Order");
        io.print("*5. Export All Data");
        io.print("*6. Quit");
        io.print("*");
        
        io.print("************************************");


        // get the menu selection
        return io.readInt("Please select from the above choices.", 1, 6);
    }
    

    // Method to get date for display order option
    // might have to change read type
    public int UserSelectionDisplayOrders(){
        return io.readInt("Enter the date of the order");

    }


  
   
    // item successfully vended
    public void displaySuccess(Order order){

        io.print("\n");
        io.print(order.getCustomerName()+ ", Order number: "+order.getOrderNumber()+" Order date: "+ order.getOrderDate()+" Added.");
    }

    
    // displays an empty line
    public void emptyLine(){
        io.print("\n");
    }

   

    // displays the exit banenr
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    // displays an unknown command banners
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    // displays the error message
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    
    // displays an error message for the date format
    public void displayDateParseException(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    
    // gets  the user entered date
    public LocalDate getOrderDate(){
        
        return io.readDate("Enter the order date in MM/dd/YYYY format: ");
        
    }
    
    // returns the date of orders
    public void returnOrderDate(LocalDate orderDate){
    
        io.print("Orders for the :" + orderDate);
    }
    
    
    // displays a list of all the orders for a date and all the info
    public void displayOrderList(List<Order> orderList) {
        
        
        
        for (Order currentOrder : orderList) {
            String orderInfo = String.format("#%s : %s %s %s %s %s %s %s %s %s",
                  currentOrder.getOrderNumber(),
                  currentOrder.getCustomerName(),
                  currentOrder.getStateAbbreviation(),
                  currentOrder.getTaxRate(),
                  currentOrder.getProductType(),
                  currentOrder.getArea(),
                  currentOrder.getMaterialCost(),
                  currentOrder.getLabourCost(),
                  currentOrder.getTaxTotal(),
                  currentOrder.getTotalCost());
            io.print(orderInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    // get the customer name
    public String getCustomerName() throws FlooringMasteryInputException {

        String custName =  io.readString("Enter the customer name");
        if (!custName.isEmpty()){
            return custName;
        }
        else throw new FlooringMasteryInputException("Input cannot be empty");
    }
    // get the state name
     public String getStateAbbrv(){
        
        return io.readString("Enter the state abbreviation");
    }
     
     // get product type
      public String getProductType(){
        
        return io.readString("Enter the product type");
    }
      
      // get product type
      public BigDecimal getArea(){
        BigDecimal area;

        // get the area and check if it is at least 100 sq ft
        do{
            area = new BigDecimal( io.readString("Enter the area"));
            if (area.compareTo(new BigDecimal(100)) < 0){
                io.print("Area is too small, minimum 100 sq ft, try again: \n");
            }
            else{
                return area;
            }
        }
        while (true);


    }
      
        // get order num 
      public int getOrderNum(){
        
        return io.readInt("Enter the order number");
    }
      
    // get the info for an order 
    public void getStoredOrderInfo(Order requestedOrder){
    
        io.print("Current order information: ");
       String orderInfo = String.format("#%s : %s %s %s %s %s %s %s %s",
                  requestedOrder.getOrderNumber(),
                  requestedOrder.getCustomerName(),
                  requestedOrder.getTaxRate(),
                  requestedOrder.getProductType(),
                  requestedOrder.getArea(),
                  requestedOrder.getMaterialCost(),
                  requestedOrder.getLabourCost(),
                  requestedOrder.getTaxTotal(),
                  requestedOrder.getTotalCost());
            io.print(orderInfo);
        
    }
    
    
    
     // date comaprison
      public BigDecimal getTaxRate(){
        
          return new BigDecimal(io.readString("Enter tax rate: "));
    }

      
    

      
      
       public String compareName(String customerName){



          return io.readString("Current customer name is "+ customerName +". To change the name"
                 + " enter the new name or to keep the name press ENTER.");
    }
       
       
        public String compareTax(String tax){
        
          return io.readString("Current tax state is "+ tax +" To change the tax state "
                 + " enter the new state or to keep the state press ENTER.");
    }
        
          public String compareProduct(String productType){
        
          return io.readString("Current product type is "+ productType +" To change the product type "
                 + " enter the new type or to keep the type press ENTER.");
    }
          
           public String compareArea(BigDecimal area){
        
          return io.readString("Current area  is "+ area +" To change the area  "
                 + " enter the new area or to keep the area press ENTER.");
    }
           
           public void removedSuccesfulDisplay(Order removedOrder){
           
               io.print("--------Removal Succesfull-------");
               io.print("Order number: " + removedOrder.getOrderNumber()+" for " +removedOrder.getOrderDate()+""
                       + " has been removed");
           
           
           }


    // date comaprison
    public void displayNoFileError(LocalDate orderDate){

         io.print("No orders for "+orderDate);
    }

    public String displayNoNameError( ){

        return "Name cannot be empty";
    }

    // returns a list of all products
    public void getAllProdcuts(List<Product> allProducts){
        io.print("Product Type | Cost per sq ft | Labour per sq ft");

        for (Product product: allProducts){
         // Print product type:  cost per square ft labour per sw ft
            String productInfo = String.format("%s : %s %s",
                    product.getProductType(),
                    product.getCostPerSquareFoot(),
                    product.getLabourCostPerSquareFoot());
            io.print(productInfo);



        }



        }
    public boolean getConfirmation(){
        io.print("Order number by default is zero because order has not been saved.");
        do {
            String userChoice = io.readString("Enter Y to SAVE order, Enter N to CANCEL");
            if (userChoice.equals("Y")|userChoice.equals("y")){
                io.print("Saving order....");
                return true;
            }
            else if (userChoice.equals("N")| userChoice.equals("n")){
                io.print("Canceling order....");
                return false;
            }

        }while (true);





    }

    public void successSaveBanner(){

        io.print("----------ORDERS SAVED SUCCESSFULLY-----");

    }



        


}

