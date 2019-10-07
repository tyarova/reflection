package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Country {

    @MyAnnotations.TestAnnotation(param1 = 100, param2 = 105)
    private int countCountryPopulation(int maleQty, int femaleQty) {
        int population = maleQty + femaleQty;
        return population;
    }
}

