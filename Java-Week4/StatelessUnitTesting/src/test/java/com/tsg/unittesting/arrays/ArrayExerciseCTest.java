
package com.tsg.unittesting.arrays;

import static com.tsg.unittesting.arrays.ArrayExerciseC.stringThemTogether;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class ArrayExerciseCTest {
    
    public ArrayExerciseCTest() {
    }

    /* Test Plan
    * stringThemTogether( { 1, 3, 3, 7 }  ) ->  "1337"
     * stringThemTogether( { 1, 33, 555, 7777, 99999 } ) ->  "133555777799999"
     * stringThemTogether( { }  ) ->  ""
     */
    
    @Test
    public void testStringThemTogether1337(){
    
      // arrange
        
        
        int[] arr = {1, 3, 3, 7};
        // act
        
        //assert
        String result =  stringThemTogether(arr);
        String expectedResult ="1337";
        
        
        assertEquals(expectedResult , result,"Expected 1337" );
    
    }
    
    
    @Test
    public void testStringThemTogether133555777799999(){
    
      // arrange
        
        
        int[] arr = {1, 33, 555, 7777, 99999};
        // act
        
        //assert
        String result =  stringThemTogether(arr);
        String expectedResult ="133555777799999";
        
        
        assertEquals(expectedResult , result,"Expected 133555777799999" );
    
    }
    
     @Test
    public void testStringThemTogetherempty(){
    
      // arrange
        
        
        int[] arr = {};
        // act
        
        //assert
        String result =  stringThemTogether(arr);
        String expectedResult ="";
        
        
        assertEquals(expectedResult , result,"Expected empty" );
    
    }
    
    
}
