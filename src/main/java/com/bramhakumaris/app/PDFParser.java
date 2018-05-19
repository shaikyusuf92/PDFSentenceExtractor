package com.bramhakumaris.app;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class PDFParser {

    private StringBuilder stringBuilder = new StringBuilder();
    private  StringBuilder result = new StringBuilder();
    private  StringBuilder pdfReader = new StringBuilder();
    protected static String filena = null;


    private String pdfParser(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        stringBuilder.setLength(0);


        try (PDDocument document = PDDocument.load(file)) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");

                for (String line : lines) {

                    stringBuilder.append(line);
                }


            }

        }

        return stringBuilder.toString();

    }


    public static void main(String[] args) throws IOException {
        PDFParser pdfParser = new PDFParser();
        FileUtils fileUtils = new FileUtils();
        DocumentCreator documentCreator = new DocumentCreator();
        PDFSentenceExtractor pdfSentenceExtractor = new PDFSentenceExtractor();
        String keyWords[] = {"soul"};
        List<String>filesList = fileUtils.getFilesList();
        System.out.println("Total Number of Files: " +filesList.size());
        System.out.println("\n");

                for (String fileName : filesList) {
                    filena = fileName;

                    System.out.println("Processing File: " + fileName);
                    pdfParser.pdfReader.setLength(0);
                    pdfParser.pdfReader.append(pdfParser.pdfParser(fileName));

                    StringTokenizer stringTokenizer = new StringTokenizer(pdfParser.pdfReader.toString(), "\\.");
                    pdfParser.result.append(pdfSentenceExtractor.extractSentences(keyWords, stringTokenizer));

                }

                documentCreator.CreateParagraph(pdfParser.result.toString());

            }

        }
