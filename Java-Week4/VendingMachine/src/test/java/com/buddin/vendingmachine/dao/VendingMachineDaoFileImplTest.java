
package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.*;
import com.buddin.vendingmachine.dto.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 * Purpose: This file tests the dao and its implementation
 */


public class VendingMachineDaoFileImplTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();


    public VendingMachineDaoFileImplTest() {
    }


    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testFile.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        dao = new VendingMachineDaoFileImpl(testFile);
    }

    



    public void testAddGetItem() throws Exception {
        Item good = new Item(50);
        good.setItemName("Pepsi");
        good.setPrice(new BigDecimal(3.25));
        good.setStock(17);

        dao.addItem(good.getId(), good);

        Item expected = dao.getItem(good.getId());

        assertEquals(good, expected);
    }

    public void testListItems() throws Exception {
        Item good1 = new Item(3);
        good1.setItemName("Starbucks");
        good1.setPrice(new BigDecimal(4.50));
        good1.setStock(6);

        dao.addItem(good1.getId(), good1);

        Item good2 = new Item(4);
        good2.setItemName("Haribos");
        good2.setPrice(new BigDecimal("0.99"));
        good2.setStock(15);

        dao.addItem(good2.getId(), good2);

        assertEquals(2, dao.getAll().size());
    }
    

    
}
