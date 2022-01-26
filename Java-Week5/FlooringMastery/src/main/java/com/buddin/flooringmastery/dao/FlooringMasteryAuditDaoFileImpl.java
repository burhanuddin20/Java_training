
package com.buddin.flooringmastery.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Audit file implementation
 */
@Component
public class FlooringMasteryAuditDaoFileImpl implements FlooringMasteryAuditDao{
    
    
    
    public static final String AUDIT_FILE = "audit.txt";
   
    public void writeAuditEntry(String entry) throws FlooringMasteryDaoPersistenceException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FlooringMasteryDaoPersistenceException("Could not persist audit information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }

}
