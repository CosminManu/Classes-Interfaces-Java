package com.pluralsight.workclasseswilson.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;        //one letter (d for divide, s for substract etc)
    private double result;

    private static int noCalculations;
    private static double sumOfCalculations;

    public MathEquation(){
        this.leftVal = 0.0;
        this.rightVal = 0.0;
        this.opCode = 'z';
        this.result = 0.0;
    }
    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch(opCode) {
            case 's':
                result = leftVal - rightVal;
                break;
            case 'a':
                result = leftVal + rightVal;
                break;
            case 'd':
                if(rightVal != 0){
                    result = leftVal / rightVal;
                }
                else {
                    System.out.println("Divide to zero not possible");
                    result = 0.0;
                }
                //result = rightVal != 0 ? leftVal / rightVal : 0.0;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:    //if user presses other than s,a,d,m
                System.out.println("Not a valid opCode: " + opCode);
                result = 0.0;
                break;
        }
        noCalculations++;
        sumOfCalculations += result;
    }
    public void execute(double leftVal, double rightVal){   //overloaded method
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }
    public void execute(int leftVal, int rightVal){   //overloaded method
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();                  // 15/4 = 3.75 (this.result)

        this.result = (int)result;  // 3.75 => 3
    }


    public static double getAverageResult(){
        return sumOfCalculations / noCalculations;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
