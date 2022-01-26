
package com.tsg.unittesting.arrays;

import static com.tsg.unittesting.arrays.ArrayExerciseA.maxOfArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class ArrayExerciseATest {
    
       /*  Test Plan:
    **  Test with numbers in order
    **  maxOfArray([1,2,3,4,5,6]) → 6
    **  maxOfArray([1,1123,43543,89131]) → 89131
    **
    **  Test with negative numbers in the list
    **  maxOfArray([-10,-7,-4,-1]) → -1
    **  maxOfArray([-10,-7,-4,-1,0]) → 0
    **  maxOfArray([54,32,-85,45,-3]) → 54
    **

    */
    
    public ArrayExerciseATest() {
    }

    @Test
    public void testMaxArray6() {
        // ARRANGE - for simple methods, this means setting up the parameters
       
        int[] Array = {1,2,3,4,5,6};
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        int result = maxOfArray(Array);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
   
        int expectedResult = 6;
        assertEquals(expectedResult , result,"{1,2,3,4,5,6}, max is 6" );
    }
    
    @Test
   public void testMaxArray89131() {
        // ARRANGE - for simple methods, this means setting up the parameters
       
        int[] Array = {1,1123,43543,89131};
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        int result = maxOfArray(Array);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
   
        int expectedResult = 89131;
        assertEquals(expectedResult , result," max is 89131" );
    }
    
    @Test
   public void testMaxArray0() {
        // ARRANGE - for simple methods, this means setting up the parameters
       
        int[] Array = {-10,-7,-4,-1,0};
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        int result = maxOfArray(Array);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
   
        int expectedResult = 0;
        assertEquals(expectedResult , result," max is 0" );
    }

  @Test
   public void testMaxArraynegative54() {
        // ARRANGE - for simple methods, this means setting up the parameters
       
        int[] Array = {54,32,-85,45,-3};
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        int result = maxOfArray(Array);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
   
        int expectedResult = 54;
        assertEquals(expectedResult , result," max is 54" );
    }
    
    
}
