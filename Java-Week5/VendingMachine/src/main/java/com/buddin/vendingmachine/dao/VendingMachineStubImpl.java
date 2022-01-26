
package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author burhan
 * @date 16 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class VendingMachineStubImpl implements VendingMachineDao{

     // item has id,name,price and stock level
     public Item onlyItem;
     
     public VendingMachineStubImpl(){

          onlyItem = new Item(1);
          onlyItem.setItemName("Fanta");
          onlyItem.setPrice(new BigDecimal("1.50"));
          onlyItem.setStock(3);

     }
     public VendingMachineStubImpl(Item testItem){

          this.onlyItem = testItem;

     }


     @Override
     public Item addItem(int id, Item good) throws VendingMachineDaoPersistenceException {
          // new item is added to the hashmap/inventory
          if(id == onlyItem.getId()){
               return onlyItem;
          }
          else{
               return null;
          }

     }

     // may not need
     @Override
     public Item updateInventory(int id,int stock) throws VendingMachineDaoPersistenceException {

         return null;
     }

     @Override
     public List<Item> getAll() throws VendingMachineDaoPersistenceException {
          List<Item> itemList = new ArrayList<>();
          itemList.add(onlyItem);
          return itemList;
     }


     @Override
     public Item getItem(int id) throws VendingMachineDaoPersistenceException {
          if(id == (onlyItem.getId())){
               return onlyItem;
          }
          else {
               return null;
          }
     }
}
