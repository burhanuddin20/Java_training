
package com.buddin.flooringmastery.dao;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Exception for no product found
 */
public class FlooringMasteryProductException extends Exception{
    
        public FlooringMasteryProductException(String message) {
            super(message);
        }

        public FlooringMasteryProductException(String message, Throwable cause) {
            super(message, cause);
        }

}
