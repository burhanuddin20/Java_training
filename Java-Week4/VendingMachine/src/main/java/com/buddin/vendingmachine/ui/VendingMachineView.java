
package com.buddin.vendingmachine.ui;

import com.buddin.vendingmachine.dto.*;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class VendingMachineView {

    // new instance of the user io
    private UserIO io;

    //constructor
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

     // All output/input from here

    // print the menu selection
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. Select Item");
        io.print("3. Add Funds");
        io.print("4. Exit");


        // get the menu selection
        return io.readInt("Please select from the above choices.", 1, 4);
    }
    // display all the items and get an option
    public void displayAllItems(List<Item> goods){
        // print  each item and the price
        io.print("--------Vending Machine -------");
        io.print("ItemId Name      Price");
        for (Item currentGood: goods){
            // might need to do price as toString?
            io.print(currentGood.getId()+"   "+currentGood.getItemName() + "      " +currentGood.getPrice());

        }
        emptyLine();
        emptyLine();


    }

    // get the item number from the customer
    public int UserSelection(){

        return io.readInt("Enter the item number");

    }

    public void DisplayUserSelection(Item good){

        io.print(good.getItemName() + " " + good.getPrice());

    }


    // When they enter money
    public void displayBalance(BigDecimal funds){

        io.print("Your balance is " + funds);
        io.readString("Please hit enter to continue");

    }


    public String displayEnterMoney(){

        io.print("----ADD FUNDS----");
        return io.readString("Please enter money first!");


    }

    public void updateStockBanner(){


         io.readString("-------UPDATE STOCK ADMIN MENU----");

    }

    public int updateStockId(){


        return io.readInt("Enter item id");

    }

    public int updateStockLevel(){


        return io.readInt("Enter item stock");

    }

    // item successfully vended
    public void displaySuccess(Item good){

        io.print("\n");
        io.print(good.getItemName() + " vended.");
    }

    public void displayChange(BigDecimal change){

        io.print("Your change back is:" +change);
    }

    public void emptyLine(){
        io.print("\n");
    }

    public void displayCoins(int quarter,int dime, int nickel, int penny){

        io.print(quarter +" quarter(s) "+ dime + " dime(s) "+ nickel+" nickel(s) "+penny+" penny(ies) ");
    }

    public void displayNoSelection(){

        io.print("No selection made");

    }

    public void enterAmount(){
        io.print("Enter an amount");
    }

    public void displayNoCoins(){

        io.print("No coins inserted");

    }

    public void displayInsufficientBalance(){

        io.print("Not enough money inserted");

    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }



}

