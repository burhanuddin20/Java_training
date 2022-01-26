package com.buddin.vendingmachine.dao;

import org.springframework.stereotype.Component;


public interface VendingMachineAuditDao {

    public void writeAuditEntry(String entry) throws VendingMachineDaoPersistenceException;

}
