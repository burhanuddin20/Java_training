package com.buddin.vendingmachine.service;

import com.buddin.vendingmachine.dao.*;


import com.buddin.vendingmachine.dto.Change;
import com.buddin.vendingmachine.dto.Item;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author burhan
 */


public class VendingMachineServiceLayerImplTest {
    
    // create new service obj
    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        
        // use the stub data sets
        VendingMachineDao dao = new VendingMachineStubImpl();
        BalanceDao balanceDao = new BalanceStubImpl();
        Change changeDao = new Change();
        VendingMachineAuditDao auditDao = new VendingMachineAuditStubImpl();
        
        // initialise the service w/ the stubs
        service = new VendingMachineServiceLayerImpl(dao,balanceDao,changeDao,auditDao);
    }


    @Test
    public void testAddItem() throws Exception {

        //Arrange
        Item testItem = new Item(13);
        testItem.setPrice(new BigDecimal("1.20"));
        testItem.setItemName("Coke");
        testItem.setStock(10);


        // ACT
        try {
            service.addItems(13, testItem);
        } catch (VendingMachineDaoPersistenceException e
        ) {
            // ASSERT
            fail("Failed to add to inventory . No exception should have been thrown.");
        }
    }


        @Test
        public void testGetAllItems() throws Exception {
            assertEquals(1, service.getAllItems().size());
        }
        
        // test the change mechanism

        


    }
    
    
