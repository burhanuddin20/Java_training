
package com.buddin.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author burhan
 * @date 19 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Stores all the different tax information
 */
public class Tax {
    
    // different information to store for the tax code
    String stateAbbreviation;
    String stateName;
    BigDecimal taxRate;
    
    public Tax(){
    
    }
    
    
    // Constructor to set the values relating state to state abbreviation
    public Tax(String stateAbbreviation,String stateName){
    
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        
    
    }
    
    // w/ just stateAbbreviation
    public Tax(String stateAbbreviation){
    
        this.stateAbbreviation = stateAbbreviation;
        
    
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    
    
    
    // state abbreviation getter
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    // get the state name
    public String getStateName() {
        return stateName;
    }

    
    // get the tax rate
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    
    // set the tax rate
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.stateAbbreviation);
        hash = 73 * hash + Objects.hashCode(this.stateName);
        hash = 73 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.stateAbbreviation, other.stateAbbreviation)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tax{" + "stateAbbreviation=" + stateAbbreviation + ", stateName=" + stateName + ", taxRate=" + taxRate + '}';
    }
    
    
    
    

}
