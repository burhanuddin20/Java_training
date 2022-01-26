
package com.buddin.flooringmastery.dao;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Exception for invalid tax
 */
public class FlooringMasteryTaxException extends Exception {
    
    
        public FlooringMasteryTaxException(String message) {
            super(message);
        }

        public FlooringMasteryTaxException(String message, Throwable cause) {
            super(message, cause);
        }

}
