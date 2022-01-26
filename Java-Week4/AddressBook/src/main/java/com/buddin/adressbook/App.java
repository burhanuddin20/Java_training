
package com.buddin.adressbook;

import com.buddin.adressbook.controller.AddressBookController;
import com.buddin.adressbook.dao.AddressBookDao;
import com.buddin.adressbook.dao.AddressBookDaoFileImpl;
import com.sg.adressbook.ui.AddressBookView;
import com.sg.adressbook.ui.UserIO;
import com.sg.adressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {
 public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(myDao, myView);
        controller.run();
    }    
    
}
