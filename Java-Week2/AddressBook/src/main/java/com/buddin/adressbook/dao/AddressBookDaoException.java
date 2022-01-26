
package com.buddin.adressbook.dao;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class AddressBookDaoException extends Exception{
    
      public AddressBookDaoException(String message) {
        super(message);
    }
    
    public AddressBookDaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
