
package com.tsg.unittesting.logic;

import static com.tsg.unittesting.logic.LogicExerciseA.friendlyGreeting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author burhan
 */


public class LogicExerciseATest {
    
    public LogicExerciseATest() {
    }
    
    /*
     *friendlyGreeting( "Goofus" , false ) ->   "hi"
     * friendlyGreeting( "Gallant" , true ) ->   "Hello, Gallant!"
     * friendlyGreeting( null , false ) ->   "..."
    */
    
    @Test
    public void testfriendlyGreetingnameandfalse() {
        
        // engage
        
        boolean isFriend = false;
        
        String visitorName = "Joe";
        
        // act
        String result = friendlyGreeting(visitorName,isFriend);
        String expectedResult = "hi";
        
       
        
        // assert
        
        assertEquals(expectedResult, result,"Strings do not match");
    }
    
    @Test
    public void testfriendlyGreetingnameandtrue() {
        
        // engage
        
        boolean isFriend = true;
        
        String visitorName = "Joe";
        
        // act
        String result = friendlyGreeting(visitorName,isFriend);
        String expectedResult = "Hello, " +visitorName+"!";
        
       
        
        // assert
        
        assertEquals(expectedResult, result,"Strings do not match");
    }
    
      @Test
    public void testfriendlyGreetingnoNameandtrue() {
        
        // engage
        
        boolean isFriend = true;
        
        String visitorName = null;
        
        // act
        String result = friendlyGreeting(visitorName,isFriend);
        String expectedResult = "...";
        
       
        
        // assert
        
        assertEquals(expectedResult, result,"Strings do not match");
    }
    
    
}
