package com.buddin.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class VendingMachinneAuditDaoFileImpl implements VendingMachineAuditDao {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws VendingMachineDaoPersistenceException {

            PrintWriter out;

            try {
                out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
            } catch (IOException e) {
                throw new VendingMachineDaoPersistenceException("Could not persist audit information.", e);
            }

            LocalDateTime timestamp = LocalDateTime.now();
            out.println(timestamp.toString() + " : " + entry);
            out.flush();
    }
}

