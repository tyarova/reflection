package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotations {

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    @interface TestAnnotation {
        int param1();
        int param2();
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @interface SaveTo {
        String path();
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    @interface DataSaver {
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.FIELD)
    @interface Save {
    }

}
