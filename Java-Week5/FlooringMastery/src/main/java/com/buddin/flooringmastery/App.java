package com.buddin.flooringmastery;

import com.buddin.flooringmastery.controller.FlooringMasteryController;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: App uses xml files to peice everything to gether and run the controller
 */
public class App {

    public static void main(String args[]){
        // use spring to get application context
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.buddin.flooringmastery");
        appContext.refresh();
        // run the controoler
        FlooringMasteryController controller = appContext.getBean("flooringMasteryController", FlooringMasteryController.class);
        controller.run();
        
        
    }    
    
}




