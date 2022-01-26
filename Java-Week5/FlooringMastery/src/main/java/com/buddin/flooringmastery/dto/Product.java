
package com.buddin.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author burhan
 * @date 19 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Product class stores information about products
 */
public class Product {
    
    
    
    String productType;
    BigDecimal costPerSquareFoot;
    BigDecimal labourCostPerSquareFoot;
    
    
     public Product(){
    
    }

    
    
    // constructor takes the product type 
    public Product(String productType){
    
        this.productType = productType;
    
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    
    
    

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLabourCostPerSquareFoot() {
        return labourCostPerSquareFoot;
    }

    public void setLabourCostPerSquareFoot(BigDecimal labourCostPerSquareFoot) {
        this.labourCostPerSquareFoot = labourCostPerSquareFoot;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.productType);
        hash = 41 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 41 * hash + Objects.hashCode(this.labourCostPerSquareFoot);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFoot, other.costPerSquareFoot)) {
            return false;
        }
        if (!Objects.equals(this.labourCostPerSquareFoot, other.labourCostPerSquareFoot)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productType=" + productType + ", costPerSquareFoot=" + costPerSquareFoot + ", labourCostPerSquareFoot=" + labourCostPerSquareFoot + '}';
    }
    
    
    
    
    

}
