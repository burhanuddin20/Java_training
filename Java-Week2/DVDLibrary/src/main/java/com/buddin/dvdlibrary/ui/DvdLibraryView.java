/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Takes all input/out using the UIimpl and stores them to the Dvd object
 */
package com.buddin.dvdlibrary.ui;

import com.buddin.dvdlibrary.dto.Dvd;
import java.util.List;


public class DvdLibraryView {
    // defining the io class as the ui
    private USERIO io;
    
    public DvdLibraryView(USERIO io){
    
        this.io = io;
    }
    
    // output all options
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List All DVDs");
        io.print("2. Add New DVD");
        io.print("3. Search For A DVD ");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
     // get info and store as new Dvd
    public Dvd getNewDvdInfo() {
        // get all the fields info
        String title = io.readString("Please enter the DVD title");
        String rating = io.readString("Please enter the rating");
        int date = io.readInt("Please enter the date as ddmmyyyy");
        String directorName = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the production studio");
        String notes = io.readString("Enter any notes you have");
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setDate(date);
        currentDvd.setDirectorName(directorName);
        currentDvd.setNote(notes);
        currentDvd.setStudio(studio);
        currentDvd.setRating(rating);
        
        return currentDvd;
    }
    
    // going to create all the banners
    
  public void displayDVDBanner() {
    io.print("=== Create DVD ===");
    }
  
  
  public void displaySuccessBanner() {
    io.readString(
            "DVD successfully created.  Please hit enter to continue");
    }
  
    // output all the info for each dvd like this
   public void displayDvdList(List<Dvd> dvdList) {
    for (Dvd currentDvd : dvdList) {
        String dvdInfo = String.format("%s : %s %s %s %s %s",
              currentDvd.getTitle(),
              currentDvd.getDate(),
              currentDvd.getRating(),
              currentDvd.getDirectorName(),
              currentDvd.getStudio(),
              currentDvd.getNote());
        io.print(dvdInfo);
    }
    io.readString("Please hit enter to continue.");
    }
   
    public void displayDisplayAllBanner() {
    io.print("=== Display All DVDs ===");
    }
   
    public void displayDisplayDvdBanner () {
    io.print("=== Display DVD ===");
    }
    
    public String getDvdTitle() {
        return io.readString("Please enter the DVD title.");
    }
    // defining how to output the dvd
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(String.valueOf(dvd.getDate()));
            io.print(dvd.getRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getNote());
            
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
     
    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }
     
    public void displayRemoveResult(Dvd dvd) {
           if(dvd != null){
             io.print("dvd successfully removed.");
           }else{
             io.print("No such dvd.");
           }
           io.readString("Please hit enter to continue.");
    }
    public void displayExitBanner() {
        io.print("Good Bye."); 
      
    }
    
    public void displayEditBanner(){
        io.print("=== Edit DVD ===");
    }
    
    public void displaySuccesfulEditBanner(){
        io.print("=== DVD Updated ===");
    }
    
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}    
