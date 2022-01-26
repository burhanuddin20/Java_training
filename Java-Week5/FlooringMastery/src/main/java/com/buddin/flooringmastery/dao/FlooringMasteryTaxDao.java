
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Tax;
import java.util.List;

/**
 *
 * @author burhan
 * @date 19 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Access to the tax class
 */
public interface FlooringMasteryTaxDao {
    
    
 
    
    // method to add a state to the Tax class
    Tax addState(String stateAbbrevaition, Tax tax)
        throws FlooringMasteryDaoPersistenceException;
    
    // Method to get a state from the List
    Tax getState(String stateAbbrevaition)
         throws FlooringMasteryDaoPersistenceException,FlooringMasteryTaxException;
    
    // Method to get all the states that in the Tax class
    List<Tax> getAllStates()
            throws FlooringMasteryDaoPersistenceException;
    
   
    
    // Method to remove a state from the list
    Tax removeState(String stateAbbrevaition)
            throws FlooringMasteryDaoPersistenceException;
    
}
