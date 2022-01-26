
package com.buddin.vendingmachine;

import com.buddin.vendingmachine.controller.VendingMachineController;
import com.buddin.vendingmachine.dao.*;
import com.buddin.vendingmachine.dto.Change;
import com.buddin.vendingmachine.service.VendingMachineServiceLayer;
import com.buddin.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.buddin.vendingmachine.ui.UserIO;
import com.buddin.vendingmachine.ui.UserIOConsoleImpl;
import com.buddin.vendingmachine.ui.VendingMachineView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {

    public static void main(String args[]){
        
        // add a new method to get the annotations
       AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.buddin.vendingmachine");
        appContext.refresh();

        VendingMachineController controller = appContext.getBean("VendingMachineController", VendingMachineController.class);
        controller.run();

    }



}
