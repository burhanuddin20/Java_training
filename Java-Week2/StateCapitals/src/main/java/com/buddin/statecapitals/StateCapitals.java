
package com.buddin.statecapitals;

import java.util.HashMap;
import java.util.Map;
import java. util. Collection;
import java.util.Set;


/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Hashmap of states and state capitals
 */
public class StateCapitals {
    
 
//Print each state along with its capital to the screen. (Hint: Use the key set to get each value from the map one by one, printing both the key and value as you go.)
    
    public static void main(String[] args) {
        
        //creating the hashmap
        Map<String, String> stateCapitals = new HashMap<>();
        
        // adding data
        stateCapitals.put("New York", "Albany");
        stateCapitals.put("California", "Sacramento");
        stateCapitals.put("Alabama", "Montgomery");
        stateCapitals.put("Arizona", "Phoenix");
        stateCapitals.put("Colorado", "Denver");
        stateCapitals.put("florida", "Tallahassee");
        
        // store all values as collection
        Collection<String> capitals = stateCapitals.values();
        
        // gets the set of keys 
        Set<String> states = stateCapitals.keySet();
        
        // enhanced for loop
        // for all states string type
        for (String c : states) {
            System.out.println(c);
        }
        System.out.println("\n");
        
        // print all capitals
        for (String s :capitals) {
            System.out.println(s);
            
        }
        
        for (String x : states) {
            System.out.println("The capital of " + x +
            " is " + stateCapitals.get(x));
}
        
        
    }   

}
