
package com.buddin.adressbook.controller;

import com.buddin.adressbook.dao.AddressBookDao;
import com.buddin.adressbook.dao.AddressBookDaoException;
import com.buddin.adressbook.dto.Address;
import com.sg.adressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class AddressBookController {
    
    private AddressBookView view;
    private AddressBookDao dao;
    
    
       public AddressBookController(AddressBookDao dao, AddressBookView view){
        
        this.dao =dao;
        this.view = view;
        
        
    }
       
       public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    viewCount();
                    break;
                case 4:
                    listAddresses();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                case 6:
                    viewAddress();
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (AddressBookDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
}
       private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    
    private void addAddress() throws AddressBookDaoException {
        
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

private void listAddresses() throws AddressBookDaoException {
    view.displayDisplayAllBanner();
    List<Address> addressList = dao.getAllAddresses();
    view.displayAddressList(addressList);
    }

private void viewAddress() throws AddressBookDaoException {
    view.displayDisplayAddressBanner();
    String lastName = view.getAddressChoice();
    Address address = dao.findAddress(lastName);
    view.displayAddress(address);
    }

private void removeAddress() throws AddressBookDaoException {
    view.displayRemoveAddresssBanner();
    String lastName = view.getAddressChoice();
    Address removedAddress = dao.removeAddress(lastName);
    view.displayRemoveResult(removedAddress);
    }

private void unknownCommand() {
    view.displayUnknownCommandBanner();
    }


private void viewCount() throws AddressBookDaoException {
    view.displayDisplayAddressCount();
    String lastName = view.getAddressChoice();
    Address address = dao.findAddress(lastName);
    view.displayAddress(address);
    }

private void exitMessage() {
    view.displayExitBanner();
  
}
    

}
