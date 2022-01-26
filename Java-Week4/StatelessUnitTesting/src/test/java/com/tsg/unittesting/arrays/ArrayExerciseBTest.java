
package com.tsg.unittesting.arrays;


import static com.tsg.unittesting.arrays.ArrayExerciseB.multiplyAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */
    /* TEST PLAN
    
    TEST W/ multiplier = 5
         * multiplyAll( 5 , [ 1 , 2, 3 , 4 , 5 ]) ->  [ 5, 10,15 , 20 , 25 ]


    
     ** multiplyAll( 0 , {1 , 2 , 3 , 4 , 5 } ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
     * multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     
    */
public class ArrayExerciseBTest {
    @Test
public void ArrayExerciseBTest5() {
        
        // arrange
        int multiplier = 5;
        int[] array = {1 , 2 , 3 , 4 , 5 };
        
        // act
        int[] result = multiplyAll(multiplier, array);
        
        //assert
        int[] expectedResult = {5,10,15,20,25};
        assertArrayEquals(expectedResult , result," 5,10,15,20,25" );

        
    }
    
@Test
public void ArrayExerciseBTest0() {
        
        // arrange
        int multiplier = 0;
        int[] array = {1 , 2 , 3 , 4 , 5 };
        
        // act
        int[] result = multiplyAll(multiplier, array);
        
        //assert
        int[] expectedResult = {0,0,0,0,0};
        
        assertArrayEquals(expectedResult , result," All should be 0" );

        
    }

    @Test
    public void ArrayExerciseBTestnegative1() {
        
        // arrange
        int multiplier = -1;
        int[] array = {-2 , 0 , 0 , 1};
        
        // act
        int[] result = multiplyAll(multiplier, array);
        
        //assert
        int[] expectedResult = {2 , 0 , 0 , -1};
        
        assertArrayEquals(expectedResult , result," 2 , 0 , 0 , -1" );
    }
}
