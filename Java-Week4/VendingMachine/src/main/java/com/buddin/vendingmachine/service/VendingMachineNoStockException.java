
package com.buddin.vendingmachine.service;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class VendingMachineNoStockException extends Exception{
    
    
      public VendingMachineNoStockException(String message) {
        super(message);
    }

    public VendingMachineNoStockException(String message, Throwable cause) {
        super(message, cause);
    }

}
