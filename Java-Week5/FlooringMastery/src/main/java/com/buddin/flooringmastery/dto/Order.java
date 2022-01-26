
package com.buddin.flooringmastery.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author burhan
 * @date 19 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Store orders as an order object
 */

// each fie
public class Order{
    
    
    // Different fields for the orders
    // Some are from different DAOs
    // local fields
    int orderNumber;
    LocalDate orderDate;
    String customerName;
    BigDecimal area;
    BigDecimal labourCost;
    BigDecimal materialCost;
    BigDecimal taxTotal;
    BigDecimal total;
    
    // cannot extend more than one class
    Product product; 
    Tax tax;
    
  // tried inheriting tax class but then order becomes a tax type 
    
  
 
    
    public Order(int orderNum){
    
        this.orderNumber = orderNum;
        
    }
    
    
    public Order(){
    
 
    }

    public Order(int orderNumber, LocalDate orderDate, String customerName, String stateAbbreviation, Product product,Tax tax, BigDecimal area) {
        
        
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.product = product;
        this.tax = tax;
        this.area = area;
        
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
    

    
    public int getOrderNumber() {
        return orderNumber;
    }



    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
   // set up the tax object
    public Tax getTaxObj( ){
    
        return this.tax;
    }
    
    // return the tax object
    public Tax setTaxObj(Tax tax){
    
        return this.tax = tax;
    }
    
    // set state abbreviation
    public void setStateAbbreviation(String stateAbbreviation){
        
        this.getTaxObj().setStateAbbreviation(stateAbbreviation);
            
    }
    
       // get state abbreviation
    public String getStateAbbreviation( ){
        
        return this.getTaxObj().getStateAbbreviation();
            
    }


        // set state name
    public void setStateName(String stateName){
        
         this.getTaxObj().setStateName(stateName);
            
    }
    
    
    
    
        // get state tax
    public BigDecimal getTaxRate( ){
        
        return this.getTaxObj().getTaxRate();
            
    }


        // set state name
    public void setTaxRate(BigDecimal taxRate){
        
         this.getTaxObj().setTaxRate(taxRate);
            
    }
    
      
    
    
        
       // get state name
    public String getStateName( ){
        
        return this.getTaxObj().getStateName();
            
    }
        
    

    // set the product 
    public void setProduct(Product product) {
         this.product = product;
    } 
    
    // set the product 
    public Product getProduct( ) {
         return this.product;
    } 
    
     
     // set the product type
    public void setProductType(String productType) {
         this.product.setProductType(productType);
    } 
    
    
    // get the product type
    public String getProductType() {
        return product.getProductType();
    }

     public BigDecimal getCostPerSquareFoot() {
        return product.getCostPerSquareFoot();
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.product.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLabourCostPerSquareFoot() {
        return this.product.labourCostPerSquareFoot;
    }

    public void setLabourCostPerSquareFoot(BigDecimal labourCostPerSquareFoot) {
        this.product.setLabourCostPerSquareFoot(labourCostPerSquareFoot);
    }
    
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
           
        
    }
    
    
 
    /*
    *MaterialCost = (Area * CostPerSquareFoot)
    *LaborCost = (Area * LaborCostPerSquareFoot)
    
    *Total = (MaterialCost + LaborCost + Tax)
    
    
    */
    
    // set the material cost, to 2 dp
     public void setMaterialCost( ) {
        // this.area or area?
         this.materialCost = product.getCostPerSquareFoot().multiply(area);
         this.materialCost = this.materialCost.setScale(2,RoundingMode.HALF_UP);
           
    }
    
    
    
    // get the material cost
    public BigDecimal getMaterialCost( ) {
        // this.area or area?
        return this.materialCost;
           
    }
    
    
    // set the labour cost
        public void setLabourCost( ) {
        // this.area or area?
        this.labourCost = (product.getLabourCostPerSquareFoot().multiply(area));
        this.labourCost = this.labourCost.setScale(2,RoundingMode.HALF_UP);
        
           
    }
    
    // get the labour cost
     public BigDecimal getLabourCost( ) {
 
        return this.labourCost;
           
    }
     
    //Tax = (MaterialCost + LaborCost) * (TaxRate/100)
    //Tax rates are stored as whole numbers 
     
    public void setTaxTotal(){
        
        this.taxTotal = (this.materialCost.add(this.labourCost)).multiply(this.tax.getTaxRate()).divide(new BigDecimal(100));
        
        
    
    }
    
    public BigDecimal getTaxTotal( ) {
        // this.area or area?
        this.taxTotal = this.taxTotal.setScale(2,RoundingMode.HALF_UP);
        
        return this.taxTotal ;

           
    }
    
    
     public void setTotalCost( ) {
       
          this.total = this.getMaterialCost().add(this.getLabourCost()).add(getTaxTotal());
                
           
           
    }
    
    public BigDecimal getTotalCost( ) {
       
        return this.total;
                
           
           
    }
    
    // Add hashcode
    // to string method

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.orderNumber;
        hash = 13 * hash + Objects.hashCode(this.orderDate);
        hash = 13 * hash + Objects.hashCode(this.customerName);
        hash = 13 * hash + Objects.hashCode(this.area);
        hash = 13 * hash + Objects.hashCode(this.labourCost);
        hash = 13 * hash + Objects.hashCode(this.materialCost);
        hash = 13 * hash + Objects.hashCode(this.taxTotal);
        hash = 13 * hash + Objects.hashCode(this.total);
        hash = 13 * hash + Objects.hashCode(this.product);
        hash = 13 * hash + Objects.hashCode(this.tax);
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
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.labourCost, other.labourCost)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.taxTotal, other.taxTotal)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        return true;
    }

    

}
