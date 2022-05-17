package com.pluralsight.workclasseswilson.calcengine.calculations;

import com.pluralsight.workclasseswilson.calcengine.CalculateBase;

public class Adder extends CalculateBase {

    @Override
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }
}
