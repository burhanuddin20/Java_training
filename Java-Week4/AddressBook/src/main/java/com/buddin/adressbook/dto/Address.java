
package com.buddin.adressbook.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.street);
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
        
        
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

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    

}
