
package com.buddin.flooringmastery.dao;

import com.buddin.flooringmastery.dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.attribute.HashAttributeSet;
import org.springframework.stereotype.Component;

/**
 *
 * @author burhan
 * @date 23 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Test data for the products
 */

public class FlooringMasteryProductDaoStub implements FlooringMasteryProductsDao{
    // test products
    private Map<String,Product> products = new HashMap<>();
        Product product1 = new Product("Carpet");
        Product product2 = new Product("Laminate");
        Product product3 = new Product("Tile");
        Product product4 = new Product("Wood");
    
    
    
    // test methods
    @Override
    public Product addproduct(String productType, Product product) throws FlooringMasteryDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getproduct(String productType) throws FlooringMasteryDaoPersistenceException {
        
        getAllproducts();
        return products.get(productType);

    }

    @Override
    public List<Product> getAllproducts() throws FlooringMasteryDaoPersistenceException {
       
       
        
        product1.setCostPerSquareFoot(new BigDecimal("2.25"));
        product1.setLabourCostPerSquareFoot(new BigDecimal("2.10"));
        products.put(product1.getProductType(), product1);
        
        product2.setCostPerSquareFoot(new BigDecimal("1.75"));
        product2.setLabourCostPerSquareFoot(new BigDecimal("2.10"));
        products.put(product2.getProductType(), product2);
        
        product3.setCostPerSquareFoot(new BigDecimal("3.50"));
        product3.setLabourCostPerSquareFoot(new BigDecimal("4.15"));
        products.put(product3.getProductType(), product3);
        
        product4.setProductType("Wood");
        product4.setCostPerSquareFoot(new BigDecimal("5.15"));
        product4.setLabourCostPerSquareFoot(new BigDecimal("4.75"));
        products.put(product4.getProductType(), product4);
        
        
        return new ArrayList<>(products.values());
        
        
    }

    @Override
    public Product removeproduct(String productType) throws FlooringMasteryDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
