package com.bramhakumaris.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.*;

public class DocumentCreator {

    public void CreateParagraph (String desiredText) throws IOException {

            //Blank Document
            XWPFDocument document = new XWPFDocument();

            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File("Final_Essence.docx"));


            //create Paragraph
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();



                String desiredTextArray[] = desiredText.split("[\\r\\n]+");
                for (String desiredTextLine : desiredTextArray) {
                    run.addBreak();
                    run.setText(desiredTextLine);
                }


                    document.write(out);
            out.close();
            System.out.println("Final_Essence.docx written successfully");
}


}
