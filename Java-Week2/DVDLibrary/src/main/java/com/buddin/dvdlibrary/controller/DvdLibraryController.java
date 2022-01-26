/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: orchestrates the entire programme calls on dependencies
 */
package com.buddin.dvdlibrary.controller;

import com.buddin.dvdlibrary.dao.DvdLibraryDao;
import com.buddin.dvdlibrary.dao.DvdLibraryDaoException;
import com.buddin.dvdlibrary.dto.Dvd;
import com.buddin.dvdlibrary.ui.DvdLibraryView;
import java.util.List;


public class DvdLibraryController {
    
    // creating the viewer and dao using the dao and view classes
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    
    // setting the properties
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view){
        
        this.dao =dao;
        this.view = view;

    }
    
    // main loop
    public void run(){
        
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            
            // run the menu selection method
            menuSelection = getMenuSelection();
            
            //  cases for menu options
            switch (menuSelection) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    createDvd();
                    break;
                case 3:
                    viewDvd();
                    break;
                case 4:
                    removeDvd();
                    break;
                case 5:
                    editDvd();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
        // catch these exceptions and return error message
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
    }
    }
    
    // runs menu viewer
    private int getMenuSelection(){    
        return view.printMenuAndGetSelection();
    
    }
    
    // uses the view and dao to create a new dvd
    private void createDvd() throws DvdLibraryDaoException {
     view.displayDVDBanner();
     Dvd newDvd = view.getNewDvdInfo();
     dao.addDvd(newDvd.getTitle(), newDvd);
     view.displaySuccessBanner();
    }
    
    // lists all the dvds
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.listAllDvd();
        view.displayDvdList(dvdList);
    }
    
    // view a certain dvd
    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitle();
        Dvd dvd = dao.viewDvd(title);
        view.displayDvd(dvd);
        }
    // remove a dvd
    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDvdTitle();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    
    // edit the info
    private void editDvd() throws  DvdLibraryDaoException{
        view.displayEditBanner();
        String title = view.getDvdTitle();
        removeDvd();
        Dvd editedDvd = view.getNewDvdInfo();
        dao.addDvd(editedDvd.getTitle(), editedDvd);
        view.displaySuccesfulEditBanner();
    }
    
    // wrong input
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
        }
    // exit message
    private void exitMessage() {
        view.displayExitBanner();

    }
    
    


}

