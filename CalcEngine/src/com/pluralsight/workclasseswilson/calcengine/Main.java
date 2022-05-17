package com.pluralsight.workclasseswilson.calcengine;

import com.pluralsight.workclasseswilson.calcengine.calculations.Adder;
import com.pluralsight.workclasseswilson.calcengine.calculations.Divider;
import com.pluralsight.workclasseswilson.calcengine.calculations.Multiplier;

public class Main {

    public static void main(String[] args) {
        //first create array of MathEq objects
        //4 equations => 4 objects => array of 4
        MathEquation[] equations = new MathEquation[4];

        //allocate mem for each individual object
        //equations[0].leftVal //private atribute, can't allocate
        equations[0] = new MathEquation(100.0,20.0, 'd');
        equations[1] = new MathEquation(25.0,10.0, 'a');
        equations[2] = new MathEquation(60.0,50.0, 's');
        equations[3] = new MathEquation(8.0,9.0, 'm');
        //equations[3] = new MathEquation(8.0,9.0, 'k');
        equations[2].setRightVal(30);

        performCalculations(equations);
        System.out.println("Total average result is: " + MathEquation.getAverageResult());

        //==============
        MathEquation equationOverload = new MathEquation('d');
        double leftValue = 9.0d;
        double rightValue = 5.0d;
        equationOverload.execute(leftValue, rightValue);    //call overload method
        System.out.println("Overloaded call result: " + equationOverload.getResult());

        int leftInt = 15;
        int rightInt = 4;
        equationOverload.execute(leftInt,rightInt);     //call overload method cast to int
        System.out.println("Overloaded call ints result: " + equationOverload.getResult());
        System.out.println();

        //===============
        Adder adder = new Adder();
        doCalculation(adder, 23, 31);
        Divider divider = new Divider();
        doCalculation(divider, 8, 3);

        //Multiplier multiplier = new CalculateBase();  //upper cast
        CalculateBase calculateBase = new Multiplier();
    }

    //same logic as performCalculations but using inheritance
    //and working with base-class CalculationBase
    private static void doCalculation(CalculateBase calculation, double left, double right){
        calculation.setLeftVal(left);
        calculation.setRightVal(right);
        calculation.calculate();        //method doesnt have its own implementation
                                        //classes that extend BaseClass come with own implementation of method
        System.out.println("Result of doCalculation: " + calculation.getResult());
    }

    private static void performCalculations(MathEquation[] equations) {
        //calculate result for all equations
        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("Operation Code: "+equation.getOpCode()
                    +", leftValue= "+equation.getLeftVal()
                    +", rightValue= "+ equation.getRightVal()
                    +", result = " + equation.getResult());
        }
    }

}
