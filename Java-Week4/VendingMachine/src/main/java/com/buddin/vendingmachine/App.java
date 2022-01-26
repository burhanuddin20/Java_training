
package com.buddin.vendingmachine;

import com.buddin.vendingmachine.controller.VendingMachineController;
import com.buddin.vendingmachine.dao.*;
import com.buddin.vendingmachine.dto.Change;
import com.buddin.vendingmachine.service.VendingMachineServiceLayer;
import com.buddin.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.buddin.vendingmachine.ui.UserIO;
import com.buddin.vendingmachine.ui.UserIOConsoleImpl;
import com.buddin.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {

    public static void main(String args[]){

        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        VendingMachineView myView = new VendingMachineView(myIo);
        // Instantiate the DAO
        VendingMachineDao vmdao = new VendingMachineDaoFileImpl();
        // other DAO

        VendingMachinneAuditDaoFileImpl auditDao = new VendingMachinneAuditDaoFileImpl();

        BalanceDao balanceDao = new BalanceDaoImpl();
        Change changeDao = new Change();

        // Instantiate the Audit DAO
        //ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(vmdao,balanceDao,changeDao,auditDao);
        // Instantiate the Controller and wire the Service Layer into it
        VendingMachineController controller = new VendingMachineController(myService, myView);
        // Kick off the Controller
        controller.run();

    }



}
