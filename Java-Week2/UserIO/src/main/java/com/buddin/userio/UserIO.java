
package com.buddin.userio;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface UserIO {
    
    void print(String message);

    String readString(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);



}
