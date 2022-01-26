package com.buddin.enummath;


import java.sql.PseudoColumnUsage;


/**
 *
 * @author burhan
 * @date 13 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class IntMath {
   public static int calculate(MathOperator operator, int operand1, int operand2) {
         switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
         }
   }
   
   
   public enum MathOperator{
   
       PLUS, MINUS, MULTIPLY, DIVIDE
   }
}