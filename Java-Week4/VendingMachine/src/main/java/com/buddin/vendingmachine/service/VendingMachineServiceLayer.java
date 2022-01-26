package com.buddin.vendingmachine.service;

import com.buddin.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.buddin.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface VendingMachineServiceLayer {

    // get all the items
    List<Item> getAllItems() throws VendingMachineDaoPersistenceException;

    // select an item
    Item selectItem(int id) throws VendingMachineDaoPersistenceException, VendingMachineNoStockException, VendingMachineInsufficientFundsException;
    void checkBalance( int id) throws VendingMachineDaoPersistenceException,VendingMachineInsufficientFundsException;


    Item getItem(int id) throws VendingMachineDaoPersistenceException;

    void addItems(int id, Item goods) throws VendingMachineDaoPersistenceException;

    BigDecimal getUserBalance() throws VendingMachineDaoPersistenceException;

    void getChange(BigDecimal change,BigDecimal itemCost);
    int returnPennies() throws VendingMachineDaoPersistenceException;
    int returnNickels()throws VendingMachineDaoPersistenceException;
    int returnDimes() throws VendingMachineDaoPersistenceException;
    int returnQuarters() throws VendingMachineDaoPersistenceException;

    void addBalance(BigDecimal moneyIn) throws VendingMachineDaoPersistenceException;

    Item updateStock(int id) throws VendingMachineDaoPersistenceException;


}
