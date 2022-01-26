
package com.buddin.adressbook.dao;

import com.buddin.adressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author: burhan
 * @date: 1 Aug 2021
 * @email: burhan.u6@hotmail.co.uk
 * purpose:
 */
public class AddressBookDaoFileImpl implements AddressBookDao{
    
    // New hash map key is last name, Address object is value
    private Map<String, Address> addressBook = new HashMap<>();
    
    // delimiter in file
    public static final String DELIMITER = "::";
    private final String ADDRESS_BOOK_FILE ;
    
    public AddressBookDaoFileImpl(){
        ADDRESS_BOOK_FILE = "addressbook.txt";
    
    }
    
    public AddressBookDaoFileImpl(String addressBookTextFile){
    
        ADDRESS_BOOK_FILE = addressBookTextFile;
    }
  
    
    @Override
    // add method takes the key last name and the address object
    public Address addAddress(String lastName, Address address)
        throws AddressBookDaoException{
   
        loadAddressBook();
        // create a new Address type object = a hashmap of the last name and object
        Address newAddress = addressBook.put(lastName, address);
        writeAddressBook();
        return newAddress;  
       
    }

    @Override
    public Address removeAddress(String lastName) 
        throws AddressBookDaoException{
        loadAddressBook();
        Address removedAddress = addressBook.remove(lastName);
        writeAddressBook();
        return removedAddress;
    }

    @Override
    public Address findAddress(String lastName) 
        throws AddressBookDaoException{
        loadAddressBook();
        return addressBook.get(lastName);
    }

    // need to check this one
    @Override
    public int numAddresses() 
        throws AddressBookDaoException{
        loadAddressBook();
        return addressBook.size();
        
    }

    @Override
    public List<Address> getAllAddresses() 
        
        throws AddressBookDaoException {
        loadAddressBook();
        return new ArrayList(addressBook.values());
       
    }
    
    


// Method that takes the line from the file and splits it
// creates a new address object
private Address unmarshallAddress(String addressAsText){
    
    // expect a string firstname::lastname::address
    String[] addressBookParts = addressAsText.split(DELIMITER);

    
    String lastName = addressBookParts[1];

  
    // new address object with id as lastName
    Address addressFromFile = new Address(lastName);

    // However, there are 3 remaining tokens that need to be set into the
    // new student object. Do this manually by using the appropriate setters.

    // Index 1 - FirstName
    addressFromFile.setFirstName(addressBookParts[0]);

    //  Address
     addressFromFile.setStreet(addressBookParts[2]);


    
    return addressFromFile;
}    


    // method to load the address book from a file and save to a file
    // takes the addressAsText
    private void loadAddressBook() throws AddressBookDaoException {
    Scanner scanner;

    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(ADDRESS_BOOK_FILE)));
    } catch (FileNotFoundException e) {
        throw new AddressBookDaoException(
                "-_- Could not load Address data into memory.", e);
    }
    
    // currentLine holds the most recent line read from the file
    String currentLine;
    
    // currentAddress holds the most recent  unmarshalled address
    Address currentAddress;
    
    // Go through ADDRESS_BOOK_FILE line by line, decoding each line into a 
    // Adress object by calling the unmarshallStudent method.
    
    // whilst there are more lines left
    while (scanner.hasNextLine()) {
        // get the next line in the file
        currentLine = scanner.nextLine();
        // unmarshall the line into an address object
        currentAddress = unmarshallAddress(currentLine);

        // We are going to use the last name  as the map key for our address object.
        // Put currentAddress into the map using last name as the key
        addressBook.put(currentAddress.getLastName(), currentAddress);
    }
    // close scanner
    scanner.close();
}

    // method to take an address object and format it for a text file
    private String marshallAddress(Address anAddress){
        // Need to take an address object and return as a line in text
        // seperated by ::

      
        // FirstName
        String addressAsText = anAddress.getFirstName() + DELIMITER;

        // LastName
        addressAsText += anAddress.getLastName() + DELIMITER;

   
        addressAsText += anAddress.getStreet();

        // We have now turned a student to text! Return it!
        return addressAsText;
    }
    
 //Writes all the addresses in the book to the file

    private void writeAddressBook() throws AddressBookDaoException {
    
     // creating a printWrite called out
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(ADDRESS_BOOK_FILE));
    } catch (IOException e) {
        throw new  AddressBookDaoException(
                "Could not save address data.", e);
    }

    // string to hold the address as text
    String AddressAsText;
    // create a list of all the addresses in 
    List<Address> addressList = this.getAllAddresses();
    
    for (Address currentAddress : addressList) {
        // turn a Student into a String
        AddressAsText = marshallAddress(currentAddress);
        // write the Student object to the file
        out.println(AddressAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
}

}

    
