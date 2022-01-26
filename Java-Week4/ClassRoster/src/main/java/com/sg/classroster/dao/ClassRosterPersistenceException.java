
package com.sg.classroster.dao;

/**
 *
 * @author burhan
 * @date 11 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class ClassRosterPersistenceException extends Exception{
    
    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
