
package com.buddin.flooringmastery.controller;

import com.buddin.flooringmastery.dao.FlooringMasteryDaoPersistenceException;
import com.buddin.flooringmastery.dao.FlooringMasteryInputException;
import com.buddin.flooringmastery.dao.FlooringMasteryTaxException;
import com.buddin.flooringmastery.dto.Order;
import com.buddin.flooringmastery.dto.Product;
import com.buddin.flooringmastery.dto.Tax;
import com.buddin.flooringmastery.ui.UserIO;
import com.buddin.flooringmastery.ui.UserIOConsoleImpl;
import com.buddin.flooringmastery.ui.FlooringMasteryView;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buddin.flooringmastery.service.FlooringMasteryServiceLayer;

import javax.swing.text.View;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Controller uses view and service layer to run the program and get the features we want
 */

@Component
public class FlooringMasteryController {

    // view and service fields
    private FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;
    // format of the date and time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

    // constructor for the controller
    @Autowired
    public FlooringMasteryController(FlooringMasteryServiceLayer service, FlooringMasteryView view) {

        this.service = service;
        this.view = view;

    }
    // main programme loop
    // displays the menu and reads the different option
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {

            while (keepGoing) {

                menuSelection = getMenuSelection();
                view.emptyLine();

                switch (menuSelection) {
                    // Display Orders
                    case 1:
                        getOrderForDate();
                        break;
                    // Add an order
                    case 2:
                        addOrder();

                        break;
                    // Edit an Order    
                    case 3:
                        editOrder();

                        break;
                    // Remove an order
                    case 4:
                        removeOrder();
                        break;

                    // Export All Data    
                    case 5:
                        exportAllData();
                        break;
                    //Quit   
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            // exit the program
            exit();
            // All the different errors that can be caught
        } catch (FlooringMasteryDaoPersistenceException ex) {

            view.displayErrorMessage(ex.getMessage());

        } catch (FileNotFoundException e) {

            view.displayErrorMessage(e.getMessage());

        } catch (FlooringMasteryTaxException e) {

            view.displayErrorMessage(e.getMessage());
            run();

        } catch (FlooringMasteryInputException e) {
            view.displayErrorMessage(e.getMessage());
            run();

        }


    }

    // if unknown command is entered return the unknown banner
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }


    // print and get the menu selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }


    // Method to exit
    private void exit() {

        view.displayExitBanner();

    }


    // method to display orders for a specific date
    private void getOrderForDate() throws FlooringMasteryDaoPersistenceException {
        // get the date from the user
        LocalDate date = view.getOrderDate();

        // try to list orders for the date
        try {
            List<Order> listOfOrders = service.getOrdersForDate(date);
            view.returnOrderDate(date);
            view.displayOrderList(listOfOrders);
        } catch (FlooringMasteryDaoPersistenceException e) {
            // if the file does not exist return an error
            view.displayNoFileError(date);
        }


    }


    //method to add a new order
    private void addOrder() throws FlooringMasteryDaoPersistenceException, FileNotFoundException, DateTimeParseException, FlooringMasteryTaxException, FlooringMasteryInputException {
        Order newOrder = new Order();
        LocalDate orderDate = view.getOrderDate();// get the date from the user
        try {

            if (orderDate.isBefore(LocalDate.now())) {// check if the date is in the future
                throw new FlooringMasteryInputException("");
            }

        } catch (FlooringMasteryInputException e) {
            view.displayErrorMessage("Order date cannot be in past\nReturning to menu...");
            throw new FlooringMasteryInputException("");
        }


        while (true) {
            try {
                // make sure the customer name is not blank
                newOrder.setCustomerName(view.getCustomerName());
                break;
            } catch (FlooringMasteryInputException e) {
                view.displayErrorMessage("Name cannot be blank, try again! \n");
            }

        }
        newOrder.setOrderNumber(0);

        Product newProduct = new Product();
        Tax newTax = new Tax();
        // Check the tax object is valid
        newTax.setStateAbbreviation(view.getStateAbbrv());
        try {
            service.getTax(newTax.getStateAbbreviation());
        } catch (FlooringMasteryTaxException e) {
            throw new FlooringMasteryTaxException(e.getMessage() + "\nReturning to main menu");

        }
        newOrder.setTaxObj(newTax);
        // Get the product name
        view.getAllProdcuts(service.getAllProducts());// returns all the product
        newProduct.setProductType(view.getProductType());
        try {

            service.getAProduct(newProduct.getProductType());// check if that product exists

        } catch (FlooringMasteryDaoPersistenceException e) {
            throw new FlooringMasteryInputException(e.getMessage() + "\nProduct does not exist\nReturning to main menu");

        }

        newOrder.setProduct(newProduct);
        newOrder.setArea((view.getArea()));// set the area
        service.createOrder(orderDate, newOrder);// create the order with all fields
        view.getStoredOrderInfo(newOrder);// display all the infor

        // confirm to user to save the data
        if (view.getConfirmation()) {
            try {
                // save the order
                // the new order number is not given
                service.saveOrder(newOrder);
                view.displaySuccess(newOrder);
            } catch (FlooringMasteryDaoPersistenceException e) {
                view.displayErrorMessage("Could not create order");
            } catch (DateTimeParseException e) {
                view.displayDateParseException("Error in date format!");
            }
        }

    }


    // edit an existing order
    private Order editOrder() throws FlooringMasteryDaoPersistenceException, FileNotFoundException, FlooringMasteryTaxException, FlooringMasteryInputException {

        Order editedOrder = new Order();


        // file to look for
        LocalDate orderDate = view.getOrderDate();
        // show a list of all the orders for that date
        view.displayOrderList(service.getOrdersForDate(orderDate));
        int orderNum = view.getOrderNum();
        // get the info for that order number
        List<Order> ordersByDate = service.getOrdersForDate(orderDate);
        view.getStoredOrderInfo(ordersByDate.get(orderNum - 1));

        // begin creating a new order to overwrite that one
        editedOrder = service.getSingleOrder(orderDate, orderNum);
        Tax tax = new Tax();
        Product product = new Product();


        // surely you can just say continue
        // took out the else statement, should not make a difference
        // check for a new name
        String newName = view.compareName(editedOrder.getCustomerName());

        if (newName.compareTo("") != 0) {

            editedOrder.setCustomerName(newName);
        }

        // get a new tax state
        String newTaxState = view.compareTax(editedOrder.getStateAbbreviation());
        if (newTaxState.compareTo("") != 0) { // check if empty input, if not

            try {
                service.getTax(newTaxState);// check if valid state
                editedOrder.setStateAbbreviation(newTaxState);

            } catch (FlooringMasteryTaxException e) {
                throw new FlooringMasteryTaxException(e.getMessage() + "\nReturning to main menu");

            }


        }


        String newProduct = view.compareProduct(editedOrder.getProduct().getProductType());// get a new product

        if (newProduct.compareTo("") != 0) {
            try {// check if the input in not empty and it is a valid product
                service.getAProduct(newProduct);
                editedOrder.getProduct().setProductType(newProduct);
            } catch (FlooringMasteryDaoPersistenceException e) {
                throw new FlooringMasteryInputException(e.getMessage() + "\nProduct does not exist\nReturning to main menu");

            }
        }

        String newArea = view.compareArea(editedOrder.getArea());
        // get a new area and check if area is larger than 100
        if (newArea.compareTo("") != 0) {
            BigDecimal area = new BigDecimal(newArea);
            if (area.compareTo(new BigDecimal(100)) < 0) {
                throw new FlooringMasteryInputException("\nInvalid Area\nReturning to main menu");
            } else {
                editedOrder.setArea(new BigDecimal(newArea));
            }
        }


        service.createOrder(orderDate,editedOrder);// create the order with all fields
        view.getStoredOrderInfo(editedOrder);
        // confirm the order again
        //  make a method for this part
        if(view.getConfirmation())
    {
        try {
            // save the order
            // the new order number is not given
            service.saveOrder(editedOrder);
            view.displaySuccess(editedOrder);
        } catch (FlooringMasteryDaoPersistenceException e) {
            view.displayErrorMessage("Could not create order");
        } catch (DateTimeParseException e) {
            view.displayDateParseException("Error in date format!");
        }
    }

        service.saveOrder(editedOrder); // save the order
        return editedOrder;

}



    
    // method to remove an order
    private void removeOrder(){
        

        
        try {
            Order removedOrder = service.removeOrder(view.getOrderDate(), view.getOrderNum());
            view.removedSuccesfulDisplay(removedOrder);
        } catch (Exception e) {
            e.getMessage();
        }
    
    }

    // saves all the data
    private void exportAllData() throws FlooringMasteryDaoPersistenceException{

       service.exportData();
       view.successSaveBanner();

    
    }
    
    
    
    
}
    

