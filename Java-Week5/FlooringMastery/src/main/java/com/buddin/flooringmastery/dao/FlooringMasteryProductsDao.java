
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Product;
import java.util.List;

/**
 *
 * @author burhan
 * @date 20 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Main behaviours of the products dao
 */
public interface FlooringMasteryProductsDao {
    
    
     // method to add a product to the Product class
    Product addproduct(String productType, Product product)
        throws FlooringMasteryDaoPersistenceException;
    
    // Method to get a product from the List
    Product getproduct(String productType)
         throws FlooringMasteryDaoPersistenceException;
    
    // Method to get all the products that are in the Product class
    List<Product> getAllproducts()
            throws FlooringMasteryDaoPersistenceException;
   
    
    // Method to remove a product from the list
    Product removeproduct(String productType)
            throws FlooringMasteryDaoPersistenceException;
    


}
