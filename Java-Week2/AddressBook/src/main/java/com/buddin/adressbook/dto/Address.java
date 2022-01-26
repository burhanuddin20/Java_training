
package com.buddin.adressbook.dto;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Address {
    
        
    // properties each object should have
        private String street;
        private String firstName;
        private String lastName;
       
    // create the setters/getters
        
        
    public Address(String lastName) {
        this.lastName = lastName;
    }    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

   
        

}
