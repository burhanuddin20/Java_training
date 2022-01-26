/**
 *
 * @author burhan
 * @date 31 July 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Interface defines the read and print methods
 */
package com.buddin.dvdlibrary.ui;


public interface USERIO {
    
    
void print(String msg);

double readDouble(String prompt);

double readDouble(String prompt, double min, double max);

float readFloat(String prompt);

float readFloat(String prompt, float min, float max);

int readInt(String prompt);

int readInt(String prompt, int min, int max);

long readLong(String prompt);

long readLong(String prompt, long min, long max);

String readString(String prompt);

}
