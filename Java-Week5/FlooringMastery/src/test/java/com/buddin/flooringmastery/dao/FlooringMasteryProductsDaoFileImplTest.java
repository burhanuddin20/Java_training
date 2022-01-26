
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Product;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 * @date 20 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Unit testing the FlooringMasteryProductsDaoFileImpl
 */


public class FlooringMasteryProductsDaoFileImplTest {
    
    FlooringMasteryProductsDao testDao;
    
    public FlooringMasteryProductsDaoFileImplTest() {
    }
    
  
    @BeforeEach
    public void setUp() throws Exception {
        // everytime this test runs create a new products test file
        // initiate a new daoFileImpl with that test file
        String testFile = "testProduct.txt";
        new FileWriter(testFile);
        testDao = new FlooringMasteryProductsDaoFileImpl(testFile);
            
    }
    
    
    
    /* Test Plan
    * Add/Get product methods
    * Takes the productType as the key and the product obj as the value
    * productType = Brick
    * costprsqft = 4.50
    * labourprsqft = 3.50
    * store and then return both of these results
    */
    @Test
    public void testAddGetProduct() throws Exception {
        // create the test inputs
        //Arrange
        String productType = "Brick";
        Product testProduct = new Product(productType);
        testProduct.setCostPerSquareFoot(new BigDecimal("4.50"));
        testProduct.setLabourCostPerSquareFoot( new BigDecimal("3.50"));
       
        //Act
        // getting an error here - NullPointerException
        testDao.addproduct(productType, testProduct);
        Product retrievedProduct = testDao.getproduct(productType);
        
        
        //Assert     
        assertEquals(retrievedProduct.getProductType(), productType,"Checking the product type");
        assertEquals(retrievedProduct.getCostPerSquareFoot(), testProduct.getCostPerSquareFoot(),"Cost per sq ft not the same");
        assertEquals(retrievedProduct.getLabourCostPerSquareFoot(), testProduct.getLabourCostPerSquareFoot(),"Labour cost per sq ft don't match");
    }
    
      /* Test Plan
    * Get All product methods
    * returns list of products
    * productType1 = Brick, productType2 = Plastic
    * costprsqft = 4.50,2.00
    * labourprsqft = 3.50,1.95
    * store and then return both of these results
    */
    
    
    @Test
    public void testGetAllProduct() throws Exception{
        //Arange
        //Set up 2 new test products
        String productType1 = "Brick";
        Product testProduct1 = new Product(productType1);
        testProduct1.setCostPerSquareFoot(new BigDecimal("4.50"));
        testProduct1.setLabourCostPerSquareFoot( new BigDecimal("3.50"));
        
        String productType2 = "Plastic";
        Product testProduct2 = new Product(productType2);
        testProduct2.setCostPerSquareFoot(new BigDecimal("2.00"));
        testProduct2.setLabourCostPerSquareFoot( new BigDecimal("1.90"));
    
        //Act
        testDao.addproduct(testProduct1.getProductType(), testProduct1);
        testDao.addproduct(testProduct2.getProductType(), testProduct2);
        
        //Assert
        
        List<Product>  allProducts = testDao.getAllproducts() ; 
        
        // First check the general contents of the list
        assertNotNull(allProducts, "The list of students must not null");
        assertEquals(2, allProducts.size(),"List of products should have 2 products.");

        // Then the specifics
        assertTrue(testDao.getAllproducts().contains(testProduct1),
                    "Should have bricks");
        assertTrue(testDao.getAllproducts().contains(testProduct2),
                "Should have plastic.");
        
    
    }
    
   
      /* Test Plan
    * Remove product1 from the product type
    * 
    * productType1 = Brick, productType2 = Plastic
    * costprsqft = 4.50,2.00
    * labourprsqft = 3.50,1.95
    * store and then return both of these results
    */
    
    
    @Test
    public void testRemoveProduct() throws Exception{
        //Arange
        //Set up 2 new test products
        String productType1 = "Brick";
        Product testProduct1 = new Product(productType1);
        testProduct1.setCostPerSquareFoot(new BigDecimal("4.50"));
        testProduct1.setLabourCostPerSquareFoot( new BigDecimal("3.50"));
        
        String productType2 = "Plastic";
        Product testProduct2 = new Product(productType2);
        testProduct2.setCostPerSquareFoot(new BigDecimal("2.00"));
        testProduct2.setLabourCostPerSquareFoot( new BigDecimal("1.90"));
    
        //Act
        testDao.addproduct(testProduct1.getProductType(), testProduct1);
        testDao.addproduct(testProduct2.getProductType(), testProduct2);
        testDao.removeproduct(productType1);
        //Assert
        
        List<Product>  allProducts = testDao.getAllproducts() ; 
       
        // First check the general contents of the list
        assertNotNull(allProducts, "The list of products must not null");
        assertEquals(1, allProducts.size(),"List of products should have 2 products.");

        // Then the specifics
        
        assertTrue(testDao.getAllproducts().contains(testProduct2),
                "Should have plastic.");
        
    
    }
    
    
}
