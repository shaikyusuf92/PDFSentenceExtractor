package com.bramhakumaris.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileUtils {

    static List<String> fileList = new ArrayList<>();
    static StringBuilder reader = new StringBuilder();
     static List<String> getFilesList() throws IOException {
        ClassLoader loader = FileUtils.class.getClassLoader();
        InputStream in = loader.getResourceAsStream(".");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = rdr.readLine()) != null) {
            if(!line.equals("com")) {
                //line = line.replaceAll("\\s+","");
                fileList.add(line);
                reader.append(line);
                reader.append("\n");
            }
        }
        rdr.close();
        return fileList;

    }

    void renameFilesInFolder()
    {
        File folder = new File("src/main/resources");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {

            if (listOfFile.isFile() && listOfFile.getName().contains(" ")) {

                System.out.println("src/main/resources/" + listOfFile.getName());
                File f = new File("src/main/resources/" + listOfFile.getName());

                f.renameTo(new File("src/main/resources/" + listOfFile.getName().replaceAll("\\s+", "")));
            }
        }

        System.out.println("File Naming Convention Checked and Corrected for Spaces");
    }



}
