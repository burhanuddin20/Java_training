/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Interface with the basic user stories
 */
package com.buddin.dvdlibrary.dao;

import com.buddin.dvdlibrary.dto.Dvd;
import java.util.List;


public interface DvdLibraryDao {

    // interface to add new dvd
    Dvd addDvd(String title, Dvd dvd)
        throws DvdLibraryDaoException;
    
    // remove a dvd
    Dvd removeDvd(String title)
        throws DvdLibraryDaoException;
    
    Dvd editDvd(String title, Dvd dvds)
        throws DvdLibraryDaoException;
    
    List<Dvd> listAllDvd()
        throws DvdLibraryDaoException;
   

    Dvd viewDvd(String title)
        throws  DvdLibraryDaoException;
    
    
            

}
