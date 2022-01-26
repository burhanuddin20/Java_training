
package com.buddin.flooringmastery.dao;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface FlooringMasteryAuditDao {

        public void writeAuditEntry(String entry) throws FlooringMasteryDaoPersistenceException;

        
}
