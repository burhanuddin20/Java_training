/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: overwrites all basic methods and has read/write using marshalling
 */
package com.buddin.dvdlibrary.dao;

import com.buddin.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.print.attribute.standard.PDLOverrideSupported;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    
    // unchanging variable for the delimiter
    public static final String DELIMITER = "::";
    // create a hashmap with the title as key and Dvd as the object
    private Map<String, Dvd> dvds = new HashMap<>();
    
    // where the info will be read and wrote too
    public static final String DVD_FILE = "DvdLibrary.txt";
    
    
    
    // overriding the main methods

    @Override
    public Dvd addDvd(String title, Dvd dvd) 
            throws DvdLibraryDaoException {
            loadLibrary();
            Dvd newDvd = dvds.put(title, dvd);
            writeLibrary();
            
            return newDvd;

    }

    @Override
    public Dvd removeDvd(String title) 
            throws DvdLibraryDaoException {
        
        loadLibrary();
        Dvd deletedDvd = dvds.remove(title);
        writeLibrary();
        
        return deletedDvd;
    }

    @Override
    public Dvd editDvd(String title,Dvd dvd) 
            throws DvdLibraryDaoException {
            
// load the dvd libray
            loadLibrary();
            Dvd editedDvd = dvds.put(title,dvd);
            
            writeLibrary();
            return editedDvd;
        
    }

    @Override
    public List<Dvd> listAllDvd() 
            throws DvdLibraryDaoException {
            loadLibrary();
            return new ArrayList(dvds.values());
  
    }

   
    
    // search for dvd by title
    // return the info
    @Override 
    public Dvd viewDvd(String title) 
            throws DvdLibraryDaoException {
            loadLibrary();

            return dvds.get(title);
    }
    
    // gets rid of the delimiters
    // takes the line from the file and creates an object with all the info
    private Dvd unmarshallDvd(String DvdAsText){
    
    // seperates the line where delimiter is and saves each part as array
    String[] dvdInfoParts = DvdAsText.split(DELIMITER);

    // the title is the first item in the info array
    String title = dvdInfoParts[0];

    // create a new dvd object from the file using the title 
    Dvd dvdFromFile = new Dvd(title);

    // add the date to the object next
    dvdFromFile.setDate(Integer.parseInt(dvdInfoParts[1]));

    // set the rating
    dvdFromFile.setRating((dvdInfoParts[2]));

    // set the directors name
    dvdFromFile.setDirectorName((dvdInfoParts[3]));
    
    // set the studio name
    dvdFromFile.setStudio((dvdInfoParts[4]));
    
    // set the user notes 
    dvdFromFile.setNote((dvdInfoParts[5]));

    return dvdFromFile;
}    
    
    // method to load the libray into memory using the unmarshall method
    private void loadLibrary() throws DvdLibraryDaoException {
    Scanner scanner;
    
    // try to read the .txt file throw an error if the file is not found
    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(DVD_FILE)));
    } catch (FileNotFoundException e) {
        throw new DvdLibraryDaoException(
                "File not found! Could not load library data into memory.", e);
    }
    // currentLine holds the most recent line read from the file
    String currentLine;
    // currentDvd holds the most recent unmarshalled dvd
    Dvd currentDvd;
    
    // Go through .txt file line by line using unmarshall method  
    // To create new Dvd objects
    
    // Run whilst there is more lines in .txt
    while (scanner.hasNextLine()) {
        // get the next line in the file
        currentLine = scanner.nextLine();
        // unmarshall the line into a Dvd type
        currentDvd = unmarshallDvd(currentLine);

        // title is the key for dvd object.
        // Store  currentDvd
        dvds.put(currentDvd.getTitle(), currentDvd);
    }
    // close scanner
    scanner.close();
    }
    
    // opposite of marshall method, takes user input
    // properties from dvd object, formats them for the text file
    // takes from memory
    private String marshallDvd(Dvd aDvd){
       

        // Get title first as that is the id
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // date
        dvdAsText += aDvd.getDate()+ DELIMITER;

        // Rating
        dvdAsText += aDvd.getRating()+ DELIMITER;

        // Directors name
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        
        // Studio 
        dvdAsText += aDvd.getStudio()+ DELIMITER;
        
        //Notes
        dvdAsText += aDvd.getNote();

        // We have now turned a student to text! Return it!
        return dvdAsText;
    }
 
    //Writes all the dvds in the library to a file
    
    private void writeLibrary() throws DvdLibraryDaoException {
    
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(DVD_FILE));
    } catch (IOException e) {
        throw new DvdLibraryDaoException(
                "Could not save the dvd data.", e);
    }

    
    String dvdAsText;
    // make a list that uses the listAllDvd method
    List<Dvd> dvdList = this.listAllDvd();
    for (Dvd currentDvd : dvdList) {
        // take each object field and marshall it
        dvdAsText = marshallDvd(currentDvd);
        // write to the file
        out.println(dvdAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
}

}
    