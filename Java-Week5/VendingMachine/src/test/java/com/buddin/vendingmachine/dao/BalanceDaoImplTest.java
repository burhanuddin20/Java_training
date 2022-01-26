
package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.dto.Balance;
import java.io.FileWriter;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 * Purpose: test the balance dao
 */


public class BalanceDaoImplTest {
    
    private BalanceDao balancedao = new BalanceDaoImpl();
    
    public BalanceDaoImplTest() {
    }
    
    
    public void testAddBalance() throws Exception {
        
        //engange
        // 2.00 test amount
        BigDecimal testAmount = new BigDecimal("2.00");
        
        //act
        
        // make the balance $2.00
        Balance testBalance = new Balance(testAmount);
        
        // expected result
        BigDecimal expectedResult = new BigDecimal("2.00");
        
        // actual result
        BigDecimal actualResult = testBalance.getFunds();
        
        //assert
      
        assertEquals(expectedResult, actualResult,"Expected result is $2.00");
    }
    
    
   
    
}
