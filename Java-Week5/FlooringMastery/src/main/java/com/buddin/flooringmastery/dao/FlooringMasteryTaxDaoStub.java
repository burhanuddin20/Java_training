
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Tax test data
 */


public class FlooringMasteryTaxDaoStub implements FlooringMasteryTaxDao{
    
    
    
    private Map<String,Tax> taxes = new HashMap<>();
    
    public FlooringMasteryTaxDaoStub(){
    }
    
    
        Tax tax1 = new Tax("WA");
        
        
        Tax tax2 = new Tax("CA");
        
        
        Tax tax3 = new Tax("TX");
        
        
        Tax tax4 = new Tax("KY");
        
    
   
    @Override
    public Tax getState(String stateAbbreviation) throws FlooringMasteryDaoPersistenceException, FlooringMasteryTaxException {
        setAllStates();
        getAllStates();
        return taxes.get(stateAbbreviation);
        
    }
    
    
    public void  setAllStates(){
        tax1.setTaxRate(new BigDecimal("9.25"));
        tax1.setStateName("Washington");
        taxes.put(tax1.getStateAbbreviation(), tax1);
        
        tax2.setTaxRate(new BigDecimal("25.00"));
        tax2.setStateName("California");
        taxes.put(tax2.getStateAbbreviation(), tax2);
        
        tax3.setTaxRate(new BigDecimal("4.45"));
        taxes.put(tax3.getStateAbbreviation(), tax3);
        tax2.setStateName("Texas");
        
        tax4.setTaxRate(new BigDecimal("6.00"));
        tax4.setStateName("Kentucky");
        taxes.put(tax4.getStateAbbreviation(), tax4);    
    
    }
    
    
    

    @Override
    public List<Tax> getAllStates() throws FlooringMasteryDaoPersistenceException {
         
        
  
        
        return new ArrayList<>(taxes.values());
    }

    @Override
    public Tax addState(String stateAbbrevaition, Tax tax) throws FlooringMasteryDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tax removeState(String stateAbbrevaition) throws FlooringMasteryDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
