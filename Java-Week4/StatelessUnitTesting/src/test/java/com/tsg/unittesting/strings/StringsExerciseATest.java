
package com.tsg.unittesting.strings;

import static com.tsg.unittesting.strings.StringsExerciseA.yell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class StringsExerciseATest {
    
    public StringsExerciseATest() {
    }
    
    /*
     * yell( "Hello there." ) ->  "HELLO THERE."
     * yell( "shhhhhhhhhhhh" ) ->  SHHHHHHHHHHHH
     * yell( "AAaAAAaAAAaaAAHHHH" ) ->  "AAAAAAAAAAAAAAHHHH"
    */

    @Test
    public void testyell() {
        // engage
        String test = "Hello there";
        
        // engage
        
        String result = yell(test);
        String expectedResult = "HELLO THERE";
        
        assertEquals(expectedResult, result, "Results match");
    }
    
    
     @Test
    public void testyell2() {
        // engage
        String test = "Hello there";
        
        // engage
        
        String result = yell(test);
        String testResult = "HellO tHerE";
        
         assertEquals(testResult, result);
        
    }
    
}
