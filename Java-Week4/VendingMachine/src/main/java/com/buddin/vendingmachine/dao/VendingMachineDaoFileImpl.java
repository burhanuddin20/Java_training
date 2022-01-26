
package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.dto.Item;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {


    // hashmap, holds each item with the item code as the key and the item obj as the values
    private Map<Integer, Item> goods = new HashMap<>();
    // text file
    private  final String INVENTORY_FILE ;
    // delimiter
    public static final String DELIMITER = "::";


    public VendingMachineDaoFileImpl(){

        INVENTORY_FILE = "stockList.txt";
    }

    public VendingMachineDaoFileImpl(String inventoryFile){

        INVENTORY_FILE = inventoryFile;
    }




    // method to add new item
    @Override
    public Item addItem(int id, Item good) throws VendingMachineDaoPersistenceException {
        // new item is added to the hashmap/inventory
        Item newGood = goods.put(id,good);
        // line to write the file here
        writeInventory();
        return newGood;
    }

    @Override
    public Item updateInventory(int id,int stock) throws VendingMachineDaoPersistenceException {
        loadInventory();
        Item updatedItem = goods.get(id);
        updatedItem.setStock(stock);
        // updated the stock level
        // want to just save that to the hashmap and update file
        goods.put(id,updatedItem);
        writeInventory();
        return updatedItem;
    }

    @Override
    public List<Item> getAll() throws VendingMachineDaoPersistenceException {
        loadInventory();
        return new ArrayList<Item>(goods.values());
    }


    @Override
    public Item getItem(int id) throws VendingMachineDaoPersistenceException {
        loadInventory();
        return goods.get(id);
    }


    private Item unmarshallInventory(String inventoryAsText){
        // store the different parts to the array
        String[]inventoryTokens = inventoryAsText.split(DELIMITER);
        // file in the form of id::name::price::stock

        // item id is the 1st thing in the file
        int id = Integer.parseInt(inventoryTokens[0]);
        // get item Name next
        String itemName = inventoryTokens[1];
        // Which we can then use to create a new item object to satisfy
        // the requirements of the item constructor.
        Item itemFromFile = new Item(id);

        // set the name
        itemFromFile.setItemName(itemName);

        // set the price as a big decimal
        itemFromFile.setPrice( new BigDecimal(inventoryTokens[2]));

        // Set the stock level
        itemFromFile.setStock(Integer.parseInt(inventoryTokens[3]));

        // return the complete item obj
        return itemFromFile;
    }


    private void loadInventory() throws VendingMachineDaoPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoPersistenceException(
                    "-_- Could not load inventory data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentItem holds the most recent student unmarshalled
        Item currentItem;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Item object by calling the unmarshallInventory method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into an Item
            currentItem = unmarshallInventory(currentLine);

            // We are going to use the Item id as the map key for our Item object.
            // Put currentIteminto the map using Item id as the key
            goods.put(currentItem.getId(), currentItem);
        }
        // close scanner
        scanner.close();
    }

    private String marshallInventory(Item item){
        // We need to turn a Item object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // itemId::ItemName::price:Stock



        // Start with the  id
        String itemAsText = item.getId() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        itemAsText += item.getItemName() + DELIMITER;

        // LastName
        itemAsText += item.getPrice() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        itemAsText += item.getStock();

        // We have now turned a student to text! Return it!
        return itemAsText;
    }
    /**
     * Writes all items in the inventory out to a INVENTORY_FILE.
     *
     * @throws VendingMachineDaoPersistenceException if an error occurs writing to the file
     */
    private void writeInventory() throws VendingMachineDaoPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoPersistenceException(
                    "Could not save student data.", e);
        }

        // Write out the Item objects to the inventory file.

        String itemAsText;
        List<Item> invetoryList = this.getAll();
        for (Item currentItem : invetoryList) {
            // turn the item into a String
            itemAsText = marshallInventory(currentItem);
            // write the Student object to the file
            out.println(itemAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }



}
