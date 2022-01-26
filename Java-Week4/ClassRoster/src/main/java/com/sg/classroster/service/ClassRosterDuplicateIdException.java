
package com.sg.classroster.service;

/**
 *
 * @author burhan
 * @date 11 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class ClassRosterDuplicateIdException extends Exception {

    public ClassRosterDuplicateIdException(String message) {
        super(message);
    }

    public ClassRosterDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause);
    }

}