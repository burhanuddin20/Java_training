
package com.tsg.unittesting.arrays;
import static com.tsg.unittesting.arrays.ArrayExerciseD.pointFree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */



 /**
     * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
     *
     * 
     * pointFree( [1.1, .22]  ) ->  22
     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     * 
     * @param numbers
     * @return
     */

public class ArrayExerciseDTest {
    
    public ArrayExerciseDTest() {
    }

    @Test
    public void testpointFree22() {
    
    
    //Arrange
    double[] arr = {1.1, .22};
    
    //Act
    int result = pointFree(arr);
    
    int expectedResult = 22;
    
    //Asser
    
        assertEquals(expectedResult, result,"Do not get 22");
    }
    
    
     @Test
    public void testpointFree5005() {
    
    
    //Arrange
    double[] arr = {.039 , 20 , .005005};
    
    //Act
    int result = pointFree(arr);
    
    int expectedResult = 5005;
    
    //Asser
    
        assertEquals(expectedResult, result,"Do not get 5005");
    }
    
    
      @Test
    public void testpointFree5() {
    
    
    //Arrange
    double[] arr = { -9.9 , -700 , -.5 };
    
    //Act
    int result = pointFree(arr);
    
    int expectedResult = -5;
    
    //Asser
    
        assertEquals(expectedResult, result,"Do not get -5");
    }
    
    
    
}
