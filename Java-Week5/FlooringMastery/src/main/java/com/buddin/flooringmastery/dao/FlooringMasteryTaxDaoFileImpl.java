
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 19 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Implements the tax dao and adds behaviours
 */
// default text file name: taxes.txt

@Component
public class FlooringMasteryTaxDaoFileImpl implements FlooringMasteryTaxDao{
    
    // hashmap holds each Tax state with the state abreviation as the key and the tax obj as value
    private Map<String, Tax> taxes = new HashMap<>();
   
   // text file to r/w from 
    private final String TAXES_FILE ;
    
    // delimiter
    public static final String DELIMITER = ",";
    
    // if constructor initialised empty use this default file
    public FlooringMasteryTaxDaoFileImpl(){
        TAXES_FILE = "taxes.txt";
    
    }
    
    // if a fileName is given use that
    public FlooringMasteryTaxDaoFileImpl(String fileName){
        TAXES_FILE = fileName;
    
    }
    
    // Add new tax info to the hashmap and then write it 
    @Override
    public Tax addState(String stateAbbrevaition, Tax tax) throws FlooringMasteryDaoPersistenceException {
        
        // new Tax state added to the hashmap
        Tax newTax = taxes.put(stateAbbrevaition, tax);
        writeTaxes();
        return newTax;
    
    }
    
     // returns an array list of all the values in the tax hashmap
    @Override
    public List<Tax> getAllStates() throws FlooringMasteryDaoPersistenceException {
        loadTax();
        return new ArrayList<Tax>(taxes.values());
    }
    
    // Get a particular tax state
    @Override
    public Tax getState(String stateAbbreviation) throws FlooringMasteryDaoPersistenceException,FlooringMasteryTaxException {
        
        loadTax();
        return taxes.get(stateAbbreviation);
    }
    
   


    @Override
    public Tax removeState(String stateAbbreviation) throws FlooringMasteryDaoPersistenceException {
            
        loadTax();
        Tax removedTax =  taxes.remove(stateAbbreviation);
        writeTaxes();
        return removedTax;

    }
    
    
    
    
      // Method to unmarshall the tax data from the tax files
     private Tax unmarshallTax(String taxAsText){
        // store the different parts to the array
        String[]taxtokens = taxAsText.split(DELIMITER);
        // file in the form of id::name::price::stock

        // State abbreviation is the 1st thing in the file
        String stateAbbreviation =taxtokens[0];
        
        // State Name next in array
        String stateName = taxtokens[1];
        
         BigDecimal taxRate = new BigDecimal(taxtokens[2]);
        // use the stateName and the stateAbbreviation to create a new tax state
        Tax taxFromFile = new Tax(stateAbbreviation,stateName);
        
        // set the tax rate
        
        taxFromFile.setTaxRate(taxRate);

        
        // return the complete item obj
        return taxFromFile;
    }
    
     // Method to marshall the tax object and fields to a csv format
     private String marshallTax(Tax tax){
        
        // Turn the tax object into :
        // StateAbbreviation::StateName::taxRate:

        // Start with the  state Abbreviation
        String taxAsText = tax.getStateAbbreviation()+ DELIMITER;

        // add the rest of the properties in the correct order:

        // the sate name
        taxAsText += tax.getStateName()+ DELIMITER;

        // tax rate
        taxAsText += tax.getTaxRate()+ DELIMITER;

        // return the line of text
        return taxAsText;
    }
     
     
     // Method to read the tax file
     // Will have to do something about the header file at the top
     private void loadTax() throws FlooringMasteryDaoPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoPersistenceException(
                    "!!!Could not load tax data into memory!!!", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTax holds the most recent tax unmarshalled
        Tax currentTax;
        
        // Go through TAXES_FILE line by line, decoding each line into a tax object
        // Via the unmarshallTax method
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into an Item
            currentTax = unmarshallTax(currentLine);

            // We are going to use the Item id as the map key for our Item object.
            // Put currentTax into  the map using state Abbreviation as the key
            taxes.put(currentTax.getStateAbbreviation(), currentTax);
        }
        // close scanner
        scanner.close();
    }
     
     
     //Method to write to a new tax file
     // Need to add a header file to the top
     private void writeTaxes() throws FlooringMasteryDaoPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(TAXES_FILE));
        } catch (IOException e) {
            throw new FlooringMasteryDaoPersistenceException(
                    "Could not save the tax data.", e);
        }

        // Write out the Item objects to the inventory file.

        String taxAsString;
        List<Tax> allTaxesList = this.getAllStates();
        
        for (Tax currentTax : allTaxesList) {
            // turn the item into a String
            taxAsString = marshallTax(currentTax);
            // write the tax object to the file
            out.println(taxAsString);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }   
  
}
