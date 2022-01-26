
package com.buddin.adressbook.dao;

import com.buddin.adressbook.dto.Address;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author burhan
 */


public class AddressBookDaoFileImplTest {
    
    AddressBookDao testDao;
   
    public AddressBookDaoFileImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testAddressBook.txt";
        // create a blank file
        new FileWriter(testFile);
        testDao = new AddressBookDaoFileImpl(testFile);
        
    }
    
    

    @Test
    public void testAddAddress() throws Exception {
        
        // create method test inputs
        // Address takes String last name and an address object
        
        String lastName = "Uddin";
        
        Address address = new Address(lastName);
        
        address.setFirstName("Burhan");
        address.setStreet("45 Canary Wharf");
        
        
        // Add the address to the DAO
       
        testDao.addAddress(lastName, address);
     
        // get the address       
        // should return the object
        Address returnedAddress = testDao.findAddress(lastName);
        
        
        // check the data is equal

        assertEquals(address.getLastName(), returnedAddress.getLastName(),
                "Checking the last names match");
        
        assertEquals(address.getFirstName(), returnedAddress.getFirstName(),
                "Checking the first names match");  
        
        assertEquals(address.getStreet(), returnedAddress.getStreet(),
                "Checking the addresses match");  
        
    }
    
      
      
    
    
     @Test
    public void testGetAllAddress() throws AddressBookDaoException {
        
        // create method test inputs
        // Address takes String last name and an address object
        
        // student one
        String lastName1 = "Uddin";
        Address address1 = new Address(lastName1);
        address1.setFirstName("Burhan");
        address1.setStreet("45 Canary Wharf");
        
        // add 2nd address
        String lastName2 = "Malone";
        Address address2 = new Address(lastName2);
        address2.setFirstName("Joe");
        address2.setStreet("1125 Canary Wharf");
        
        
        // Add the addresses to the DAO
        testDao.addAddress(lastName1, address1);
        testDao.addAddress(lastName2, address2);
        
        // get the address
        
        List<Address> allAdresses = testDao.getAllAddresses();
   
        // check the data is equal
        
        
           // First check the general contents of the list
        assertNotNull(allAdresses, "The list of addresses must not null");
        assertEquals(2, allAdresses.size(),"List of addresses should have 2 .");

        // Then the specifics
        assertTrue(testDao.getAllAddresses().contains(address1),
                    "The list of address should include Uddin.");
        assertTrue(testDao.getAllAddresses().contains(address2),
                "The list of address should include Malone.");

    }
    
      @Test
    public void testRemoveAddress() throws AddressBookDaoException {
        
        // create method test inputs
        // Address takes String last name and an address object
        
        // student one
        String lastName1 = "Uddin";
        Address address1 = new Address(lastName1);
        address1.setFirstName("Burhan");
        address1.setStreet("45 Canary Wharf");
        
        // add 2nd address
        String lastName2 = "Malone";
        Address address2 = new Address(lastName2);
        address2.setFirstName("Joe");
        address2.setStreet("1125 Canary Wharf");
        
        
        // Add the addresses to the DAO
        testDao.addAddress(lastName1, address1);
        testDao.addAddress(lastName2, address2);
        
        // remove the first address
        
        Address removedAddress = testDao.removeAddress(address1.getLastName());
        assertEquals(removedAddress, address1, "Uddin shouldbe removed");
          
        // Get all the addresses
        List<Address> allAdresses = testDao.getAllAddresses();
        
        // First check the general contents of the list
        assertNotNull(allAdresses, "The list of addresses must not null");
        assertEquals(1, allAdresses.size(),"List of addresses should have 1 .");

        // Then the specifics
          assertFalse(allAdresses.contains(address1),"Should not be included");
          assertTrue(allAdresses.contains(address2), "Should include Malone");
       
          
         removedAddress = testDao.removeAddress(address2.getLastName());
         assertEquals(removedAddress, address2, "Malone shouldbe removed");
          
         allAdresses = testDao.getAllAddresses();
         
          assertTrue(allAdresses.isEmpty(),"List should be empty");
          
          // check the ids - both hsould be null
          Address returnedAddress = testDao.findAddress(address1.getLastName());
          assertNull(returnedAddress,"Uddin should be null");
          
          returnedAddress = testDao.findAddress(address2.getLastName());
          assertNull(returnedAddress,"Malone should be null");
          
    }
}
    
    
    // test the get all addresses method next