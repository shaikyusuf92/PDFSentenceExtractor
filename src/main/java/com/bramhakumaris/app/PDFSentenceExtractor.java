package com.bramhakumaris.app;


import java.io.IOException;
import java.util.*;

class PDFSentenceExtractor {


    private StringBuilder sb = new StringBuilder();
    private Set<String> removeDuplicateSearches = new LinkedHashSet<>();


    String extractSentences(String keyWords[], StringTokenizer tokenizer) throws IOException {

        while (tokenizer.hasMoreTokens()) {
            String x = tokenizer.nextToken();

            for (final String s : x.split(" ")) {
                for (String keyword : keyWords) {
                    if (keyword.equals(s)) {
                        removeDuplicateSearches.add(x);
                    }
                }
            }

        }

        List<String> finalSearchResult = new ArrayList<>(removeDuplicateSearches);
        sb.setLength(0);
        sb.append("\n");
        sb.append("******************************");
        sb.append("Murali Date: ").append(PDFParser.filena).append("**********************").append("\n");
        int keyWordCount = 1;
        for(String result: finalSearchResult)
        {

            if (keyWordCount == 1) {
                sb.append(keyWordCount).append(". ").append(result);
            } else {
                sb.append("\n");
                sb.append(keyWordCount).append(". ").append(result);
            }
            keyWordCount++;
        }
        finalSearchResult.clear();
        removeDuplicateSearches.clear();
        return sb.toString();

    }


}
