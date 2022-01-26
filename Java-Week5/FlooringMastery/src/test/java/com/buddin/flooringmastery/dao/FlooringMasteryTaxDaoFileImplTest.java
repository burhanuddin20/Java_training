
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Tax;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class FlooringMasteryTaxDaoFileImplTest {
    
    public FlooringMasteryTaxDaoFileImplTest() {
    }
    
    
    FlooringMasteryTaxDao testDao;
 
    
  
   // for some reason the beforeEach is not running
    @BeforeEach
    public void setUp() throws Exception {
        // everytime this test runs create a new products test file
        // initiate a new daoFileImpl with that test file
        String testFile = "testTax.txt";
        new FileWriter(testFile);
        testDao = new FlooringMasteryTaxDaoFileImpl(testFile);
            
    }
    
    
    
    /* Test Plan
    * Add/Get tax methods
    * Takes the state abbreviation as the key and the Tax obj as the value
    * State Abbreviation: TX
    * Name: Texas
    * tax rate: 4.45
    * store and then return both of these results
    */
    @Test
    public void testAddGetTax() throws Exception {
        // create the test inputs
        //Arrange
        String stateAbbreviation = "TX";
        Tax testTax = new Tax(stateAbbreviation);
        testTax.setStateName("Texas");
        testTax.setTaxRate(new BigDecimal("4.45"));
       
        //Act
        // getting an error here - NullPointerException
        testDao.addState(stateAbbreviation, testTax);
        Tax retrievedTax = testDao.getState(stateAbbreviation);
        
        
        //Assert     
        assertEquals(retrievedTax.getStateAbbreviation(), stateAbbreviation,"Checking the state");
        assertEquals(retrievedTax.getStateName(), testTax.getStateName()," state names dont ");
        assertEquals(retrievedTax.getTaxRate(), testTax.getTaxRate(),"Tax rates don't match");
    }
    
      /* Test Plan
    * Get All product methods
    * returns list of tax states
    * stateAbbreviation1 = TX, stateAbbreviation2 = CA
    * STATE NAME = Texas,California
    * tax rate = 4.45,25.00
    * store and then return both of these results
    */
    
       @Test
    public void testGetAllTax() throws Exception {
        //Arange
        //Set up 2 new test taxes
        String stateAbbreviation = "TX";
        Tax testTax = new Tax(stateAbbreviation);
        testTax.setStateName("Texas");
        testTax.setTaxRate(new BigDecimal("4.45"));

        String stateAbbreviation2 = "CA";
        Tax testTax2 = new Tax(stateAbbreviation2);
        testTax2.setStateName("California");
        testTax2.setTaxRate(new BigDecimal("25.00"));


        //Act
        testDao.addState(stateAbbreviation, testTax);
        testDao.addState(stateAbbreviation2, testTax2);

        //Assert
        List<Tax> allTaxes = testDao.getAllStates();

        // First check the general contents of the list
        assertNotNull(allTaxes, "The list of students must not null");
        assertEquals(2, allTaxes.size(), "List of products should have 2 products.");

        // Then the specifics
        assertTrue(testDao.getAllStates().contains(testTax),
                "Should have Texas");
        assertTrue(testDao.getAllStates().contains(testTax2),
                "Should have California.");

    }

    /* Test Plan
    * Remove TX from the taxes
    * 
    * returns list of tax states
    * stateAbbreviation1 = TX, stateAbbreviation2 = CA
    * STATE NAME = Texas,California
    * tax rate = 4.45,25.00
    * remove Texas
    */
    
    @Test
    public void testRemoveTax() throws Exception {
        //Arange
        //Set up 2 new test taxes
        String stateAbbreviation = "TX";
        Tax testTax = new Tax(stateAbbreviation);
        testTax.setStateName("Texas");
        testTax.setTaxRate(new BigDecimal("4.45"));

        String stateAbbreviation2 = "CA";
        Tax testTax2 = new Tax(stateAbbreviation2);
        testTax2.setStateName("California");
        testTax2.setTaxRate(new BigDecimal("25.00"));

        //Act
        testDao.addState(stateAbbreviation, testTax);
        testDao.addState(stateAbbreviation2, testTax2);
        testDao.removeState(stateAbbreviation);
        //Assert

        List<Tax> allTaxes = testDao.getAllStates();
        
        // First check the general contents of the list
        assertNotNull(allTaxes, "The list of students must not null");
        assertEquals(1, allTaxes.size(), "List of products should have 2 products.");

        // Then the specifics
        assertTrue(testDao.getAllStates().contains(testTax2),
                "Should have California.");

    }
    

    
}
