/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: contains main class and starts the program
 */
package com.buddin.dvdlibrary;

import com.buddin.dvdlibrary.controller.DvdLibraryController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
 
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = ctx.getBean("controller", DvdLibraryController.class);
        // runs main loop from controller
        controller.run();
        
    }
    


}
