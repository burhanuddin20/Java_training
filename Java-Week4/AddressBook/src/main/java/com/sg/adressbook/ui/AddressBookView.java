
package com.sg.adressbook.ui;

import com.buddin.adressbook.dto.Address;
import java.util.List;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class AddressBookView {
    
     private UserIO io;
     
     public AddressBookView(UserIO io){
     this.io = io;
     }
     
     public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Addresses");
        io.print("2. Remove Addresses");
        io.print("3. View total number of addresses");
        io.print("4. List all addresses");
        io.print("5. find address by last name");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
     
     public Address getNewAddressInfo(){
         String firstName = io.readString("Please enter the first name");
         String lastName = io.readString("Please enter the last name");
         String street = io.readString("Please enter the address");
         
         Address currentAddress = new Address(lastName);
         currentAddress.setFirstName(firstName);
         currentAddress.setStreet(street);
         return currentAddress;
     
     }
     
     public void displayCreateAddressBanner() {
    io.print("=== Create Address ===");
    }
     
    public void displayCreateSuccessBanner() {
    io.readString("Address successfully created.  Please hit enter to continue");
    }
    
    public void displayAddressList(List<Address> addressList) {
    for (Address currentAddress : addressList) {
        String addressInfo = String.format("#%s : %s %s",
              currentAddress.getFirstName(),
              currentAddress.getLastName(),
              currentAddress.getStreet());
        io.print(addressInfo);
    }
    io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
    io.print("=== Display All Addresses ===");
    }
    
    public void displayDisplayAddressBanner () {
    io.print("=== Display Address ===");
}

    public String getAddressChoice() {
        return io.readString("Please enter the last name of the contact .");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreet());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveAddresssBanner () {
    io.print("=== Remove Addresss ===");
    }

    public void displayRemoveResult(Address addressBook) {
        if(addressBook != null){
          io.print("Address successfully removed.");
        }else{
          io.print("No such Address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
    io.print("Good Bye!!!");
}

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
    
    public void displayDisplayAddressCount () {
    io.print("=== Total number of Addresses ===");
}
     
     

}
