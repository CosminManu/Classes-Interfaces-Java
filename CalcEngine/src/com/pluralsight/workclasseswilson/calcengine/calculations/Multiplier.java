package com.pluralsight.workclasseswilson.calcengine.calculations;

import com.pluralsight.workclasseswilson.calcengine.CalculateBase;

public class Multiplier extends CalculateBase {
    @Override
    public void calculate() {
        double result = getLeftVal() * getRightVal();
        setResult(result);
    }
}
