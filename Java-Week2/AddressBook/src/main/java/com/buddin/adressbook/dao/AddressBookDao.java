
package com.buddin.adressbook.dao;

import com.buddin.adressbook.dto.Address;
import java.util.List;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Addressbook interface, main functionality of address book
 */
public interface AddressBookDao {
    
     
    //Add an Address
    Address addAddress(String lastName, Address address)
        throws AddressBookDaoException;
    
    // remove address
    Address removeAddress(String lastName)
        throws AddressBookDaoException;
    
    //Find address by Last name
    
    Address findAddress(String Name)
        throws AddressBookDaoException;
    
    // count of the addresses
    int numAddresses()
        throws AddressBookDaoException;
    
     //Get all addresses
    List<Address> getAllAddresses()
        throws AddressBookDaoException;
    
    
}
