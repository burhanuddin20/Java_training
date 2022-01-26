/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: contains main class and starts the program
 */
package com.buddin.dvdlibrary;

import com.buddin.dvdlibrary.controller.DvdLibraryController;
import com.buddin.dvdlibrary.dao.DvdLibraryDao;
import com.buddin.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.buddin.dvdlibrary.ui.DvdLibraryView;
import com.buddin.dvdlibrary.ui.USERIO;
import com.buddin.dvdlibrary.ui.USERIOConsoleImpl;


public class App {
 
    public static void main(String[] args) {
        // createa a new ui obj
        USERIO myIo = new USERIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        // runs main loop from controller
        controller.run();
        
    }
    


}
