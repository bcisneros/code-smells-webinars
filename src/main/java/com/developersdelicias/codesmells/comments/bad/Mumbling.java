package com.developersdelicias.codesmells.comments.bad;

import java.io.File;
import java.io.IOException;

public class Mumbling {

    public void load(String fileName) {

        try {
            File file = new File(fileName);
            // ....


        } catch (Exception e) {
            // No file loaded means default is loaded
        }
    }
}
