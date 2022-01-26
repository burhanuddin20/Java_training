
package com.sg.classroster.dao;

/**
 *
 * @author burhan
 * @date 11 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface ClassRosterAuditDao {
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
   
}