
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 20 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: ProductDao is responsible for interacting with the class object and the file to r/w data
 */
@Component
public class FlooringMasteryProductsDaoFileImpl implements FlooringMasteryProductsDao{
    
    
    // hashmap holds each product with the product type  as the key and the product obj as value
    private Map<String, Product> products = new HashMap<>();
   
   // text file to r/w from 
    private final String PRODUCTS_FILE ;
    
    // delimiter
    public static final String DELIMITER = ",";
    
    // if constructor initialised empty use this default file
    public FlooringMasteryProductsDaoFileImpl(){
        PRODUCTS_FILE = "products.txt";
    
    }
    
    // if a fileName is given use that
    public FlooringMasteryProductsDaoFileImpl(String fileName){
        PRODUCTS_FILE = fileName;
    
    }
    
    
    // Add a new product to the list
    @Override
    public Product addproduct(String productType, Product product) throws FlooringMasteryDaoPersistenceException {
        Product newProduct = products.put(productType, product);
        writeProduct();
        return newProduct;

    }
    

    // get a certain product from file
    @Override
    public Product getproduct(String productType) throws FlooringMasteryDaoPersistenceException {
        
        loadProduct();
        return products.get(productType);
       
    
    }
    
    // returns an array list of all the values in the products hashmap
   
    @Override
    public List<Product> getAllproducts() throws FlooringMasteryDaoPersistenceException {
        loadProduct();
        return new ArrayList<Product>(products.values());


    }
    
   

    @Override
    public Product removeproduct(String productType) throws FlooringMasteryDaoPersistenceException {
        loadProduct();
        Product removedProduct = products.remove(productType);
        writeProduct();
        return removedProduct;


    }
    
    
    
    
     // For both of these methods need to do something about the r/w headers
      
      // Method to unmarshall the product data from the product file
     private Product unmarshallProduct(String productAsText){
        // store the different parts to the array
        String[]producttokens = productAsText.split(DELIMITER);
        // file in the form of id::name::price::stock

        // Product Type - id for the products map
        String productType  = producttokens[0];
        // create a new product object using the new type
        Product productFromFile = new Product(productType);
        
        // set the  costPerSquareFoot,labourCostPerSquareFoot fields;

        productFromFile.setCostPerSquareFoot( new BigDecimal(producttokens[1]));
        productFromFile.setLabourCostPerSquareFoot(new BigDecimal(producttokens[2]));

        
        // return the complete item obj
        return productFromFile;
    }
    
     // Method to marshall the product object and fields to a csv format
     private String marshallProduct(Product product){
        
        // Turn the product object into :
        // Product Type:: Cost per sqft::Labour per sqft:

        // Start with the product Type
        String prodcutAsString = product.getProductType()+ DELIMITER;

        // add the rest of the properties in the correct order:

        // the cost per sq ft
        prodcutAsString += product.getCostPerSquareFoot()+ DELIMITER;

        // labour per sq ft
        prodcutAsString += product.getLabourCostPerSquareFoot()+ DELIMITER;

        // return the line of text
        return prodcutAsString;
    }
     
     
     // Method to read the product  file
     // Will have to do something about the header file at the top
     private void loadProduct() throws FlooringMasteryDaoPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoPersistenceException(
                    "!!!Could not load product data into memory!!!", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTax holds the most recent product unmarshalled
        Product currentProduct;
        
        // Go through TAXES_FILE line by line, decoding each line into a product object
        // Via the unmarshallTax method
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into an Item
            currentProduct = unmarshallProduct(currentLine);

            // We are going to use the Item id as the map key for our Item object.
            // Put currentTax into  the map using state Abbreviation as the key
            products.put(currentProduct.getProductType(), currentProduct);
        }
        // close scanner
        scanner.close();
    }
     
     
     //Method to write to a new product file
     // Need to add a header file to the top
     private void writeProduct() throws FlooringMasteryDaoPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(PRODUCTS_FILE));
        } catch (IOException e) {
            throw new FlooringMasteryDaoPersistenceException(
                    "Could not save the product data.", e);
        }

        // Write out the Item objects to the inventory file.

        String productsAsString;
        List<Product> allProducts = this.getAllproducts();
        
        for (Product currentProduct : allProducts) {
            // turn the item into a String
            productsAsString = marshallProduct(currentProduct);
            // write the product object to the file
            out.println(productsAsString);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }   
    
    
    

}
