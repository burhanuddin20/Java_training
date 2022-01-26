
package com.buddin.vendingmachine.controller;

import com.buddin.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.buddin.vendingmachine.dto.Balance;
import com.buddin.vendingmachine.dto.Change;
import com.buddin.vendingmachine.dto.Item;
import com.buddin.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.buddin.vendingmachine.service.VendingMachineNoStockException;
import com.buddin.vendingmachine.service.VendingMachineServiceLayer;
import com.buddin.vendingmachine.ui.UserIO;
import com.buddin.vendingmachine.ui.UserIOConsoleImpl;
import com.buddin.vendingmachine.ui.VendingMachineView;

import javax.swing.text.View;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */

@Component
public class VendingMachineController {
    
    
    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    @Autowired
    public VendingMachineController(VendingMachineServiceLayer service,VendingMachineView view){

        this.service = service;
        this.view = view;

    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                view.emptyLine();

                switch (menuSelection) {
                    case 1:
                        listAllItems();
                        break;
                    case 2:
                        selectItem();
                        break;
                    case 3:
                        addFunds();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }

            exit();
        } catch (VendingMachineDaoPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (VendingMachineNoStockException e) {
            // add individual messages here
            e.printStackTrace();
        } catch (VendingMachineInsufficientFundsException e) {
            e.printStackTrace();
        }
    }

    // if unknown command is entered return the unknown banner
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void checkBalance() throws VendingMachineDaoPersistenceException, VendingMachineInsufficientFundsException{

        BigDecimal userFunds = service.getUserBalance();

        if (userFunds == null || userFunds.equals(BigDecimal.ZERO)){

            addFunds();
            listAllItems();
        }


    }

    private void selectItem() throws VendingMachineDaoPersistenceException, VendingMachineNoStockException, VendingMachineInsufficientFundsException {
        try{view.displayBalance(service.getUserBalance());}
        catch (NullPointerException e){view.displayEnterMoney();
        }
        // check if user has a balance
        checkBalance();

        // if there is a balance


        // get the id of the item
        int itemId = view.UserSelection();
        view.DisplayUserSelection(service.getItem(itemId));


        // // the service layer will check if items are in list, if there is enough money etc
        // maybe need a try and catch statement
        try {
            service.selectItem(itemId);
            view.displaySuccess(service.selectItem(itemId));


        } catch (VendingMachineDaoPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
        // reduce the inventory

        // return change
        BigDecimal itemCost = service.getItem(itemId).getPrice();
        BigDecimal change = service.getUserBalance().subtract(itemCost);
        service.updateStock(itemId); // update the inventory
        returnChange(change,itemCost);

        // success if item


    }

    // call the add money input and store it
    private void addFunds() throws VendingMachineDaoPersistenceException {
        BigDecimal userMoney = new BigDecimal(view.displayEnterMoney());
        service.addBalance(userMoney);
        // confirm money is in system
        view.displayBalance(service.getUserBalance());
    }



    // print and get the menu selection
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    // get all the items and use view to print them
    private  void listAllItems() throws VendingMachineDaoPersistenceException {

        List<Item>  goods = service.getAllItems();
        view.displayAllItems(goods);

    }

    private  void exit(){

        view.displayExitBanner();

    }

    private void returnChange(BigDecimal change , BigDecimal itemCost ) throws VendingMachineDaoPersistenceException {

            service.getChange(change,itemCost);

            view.displayCoins(service.returnQuarters(),service.returnDimes(),service.returnNickels(),service.returnPennies());

    }



}
    

