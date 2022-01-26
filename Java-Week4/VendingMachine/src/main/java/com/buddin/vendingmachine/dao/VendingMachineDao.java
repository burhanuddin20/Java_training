
package com.buddin.vendingmachine.dao;


import com.buddin.vendingmachine.dto.Item;

import java.util.List;


/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface VendingMachineDao {
    
    
    // all basic methods defined here
    // get Inventory items
    
    // Method to add an item- for admin use only

    Item addItem(int itemId, Item good)
            throws VendingMachineDaoPersistenceException;

    // method to update item stock
    Item updateInventory(int id,int stock)
            throws VendingMachineDaoPersistenceException;

    // have to change to hashmap type
    List<Item> getAll()
        throws VendingMachineDaoPersistenceException;

    Item getItem (int id)
            throws VendingMachineDaoPersistenceException;

}
