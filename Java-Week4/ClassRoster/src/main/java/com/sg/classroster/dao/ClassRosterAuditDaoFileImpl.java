
package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author burhan
 * @date 11 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
 
    public static final String AUDIT_FILE = "audit.txt";
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
 
}