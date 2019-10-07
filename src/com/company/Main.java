package com.company;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //First task solution
        Country country = new Country();
        Class<?> cls = country.getClass();
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotations.TestAnnotation.class)) {
                method.setAccessible(true);
                MyAnnotations.TestAnnotation ta = method.getAnnotation(MyAnnotations.TestAnnotation.class);
                int result = 0;
                try {
                    result = (Integer) method.invoke(country, ta.param1(), ta.param2());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
            }
        }
        //Second task solution
        TextContainer tc = new TextContainer();
        Class<?> cls1 = tc.getClass();

        if (!cls1.isAnnotationPresent(MyAnnotations.SaveTo.class)) {
            System.out.println("There is no needed annotation");
        } else {
            MyAnnotations.SaveTo saveTo = cls1.getAnnotation(MyAnnotations.SaveTo.class);
            String path = saveTo.path();
            Method[] methods1 = cls1.getDeclaredMethods();
            for (Method method : methods1) {
                if (method.isAnnotationPresent(MyAnnotations.DataSaver.class)) {
                    method.invoke(tc, path);
                    System.out.println("data have been saved to file");
                }
            }
        }
        //Method to clean after file creation
        tc.deleteFile("test.txt");

        //Third task solution
        FieldsToSerialize fields = new FieldsToSerialize();
        Class<?> cls2 = fields.getClass();
        Field[] fieldsToSerialize = cls2.getDeclaredFields();

        for (Field f : fieldsToSerialize) {
            if (f.isAnnotationPresent(MyAnnotations.Save.class)) {
                f.setAccessible(true);
            }
        }

    }
}
