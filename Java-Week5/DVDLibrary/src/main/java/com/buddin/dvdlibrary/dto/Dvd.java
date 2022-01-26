/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Defines the Dvd class, properties, constructor and setters/getters
 */
package com.buddin.dvdlibrary.dto;

public class Dvd {
    
    // properties of dvd object
    private String title;
    private int date;
    private String rating;
    private String directorName;
    private String studio;
    private String note;

    // constructor uses title as the id
    public Dvd(String title){
        this.title = title;
    
    }
    
    // setters and getters for all the other fields
    public String getTitle() {
        return title;
    }

    // returns date
    public int getDate() {
        return date;
    }
    
    // sets date
    public void setDate(int date) {
        this.date = date;
    }
    
    //gets rating
    public String getRating() {
        return rating;
    }
    
    //sets rating
    public void setRating(String rating) {
        this.rating = rating;
    }
    //gets directors name
    public String getDirectorName() {
        return directorName;
    }
    //sets directors name
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    //gets studio name
    public String getStudio() {
        return studio;
    }
    //sets studio name
    public void setStudio(String studio) {
        this.studio = studio;
    }
    //gets any other notes 
    public String getNote() {
        return note;
    }
    //sets the notes 
    public void setNote(String note) {
        this.note = note;
    }
    

   

}
