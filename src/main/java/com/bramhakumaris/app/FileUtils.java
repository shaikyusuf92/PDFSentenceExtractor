package com.bramhakumaris.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    List<String> fileList = new ArrayList<>();
    StringBuilder reader = new StringBuilder();
    public List<String> getFilesList() throws IOException {
        ClassLoader loader = FileUtils.class.getClassLoader();
        InputStream in = loader.getResourceAsStream(".");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = rdr.readLine()) != null) {
            if(!line.equals("com")) {
                fileList.add(line);
                reader.append(line);
                reader.append("\n");
            }
        }
        rdr.close();
        return fileList;

    }

}
