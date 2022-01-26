/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Inherits exception class and has constructors for different scenarios
 */
package com.buddin.dvdlibrary.dao;


public class DvdLibraryDaoException extends Exception{
    
      public DvdLibraryDaoException(String message) {
        super(message);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
