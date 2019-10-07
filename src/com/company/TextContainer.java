package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotations.SaveTo(path = "test.txt")
public class TextContainer {

    public String stroka = "Random text to use";

    @MyAnnotations.DataSaver
    public void saveTextToFile(String path) throws IOException {
        FileWriter file = new FileWriter(path);
        try {
            file.write(stroka);
        } finally {
            file.close();
        }
    }

    public void deleteFile(String path){
        File file = new File(path);
        file.delete();
    }
}
