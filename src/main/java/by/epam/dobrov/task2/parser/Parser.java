package by.epam.dobrov.task2.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class Parser {

    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public static boolean isLineReaderNotNull(String line) {
        if (line != null) {
            return true;
        }
        return false;
    }

    public static List<String> parseParagraphListFromText(String filepath) {
        LOGGER.info("Text parsing is started");
        List<String> paragraphBuffList = new ArrayList<String>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));

            String paragraph;

            while (isLineReaderNotNull(paragraph = reader.readLine())) {
                paragraphBuffList.add(paragraph);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found, please check you filepath");
            LOGGER.warn("File is not found, please check you filepath or availability of File");

        } catch (IOException e) {
            System.out.println("Please check your file, input problems ");
            LOGGER.error("File error, reading problems with input file");
        }
        LOGGER.info("Getting paragraphList from {}", filepath);
        return paragraphBuffList;
    }

    public static String[] splitUpParagraph(String paragraph) {

        String[] arrSentences = paragraph.split("(?<=[.!?])\\s* ");

        return arrSentences;
    }

    public static List<String> parseSentenceListFromParagraph(String paragraph) {
        LOGGER.info("Started to split up paragraph into sentenceList");

        List<String> sentenceBuffList = new ArrayList<String>();

        for (String sentence : splitUpParagraph(paragraph)) {
            sentenceBuffList.add(sentence);
        }

        LOGGER.info("Finished to split up paragraph into sentenceList");
        return sentenceBuffList;
    }

    public static String[] splitUpSentence(String sentence) {

        String newStr = sentence.trim();
        String replaceSpace = newStr.replaceAll("\\s+", " ");
        String[] arrWords = replaceSpace.split("[ ]|(?<=[,])\\s* ");

        return arrWords;
    }

    public static List<String> parseWordListFromSentence(String sentence) {
        LOGGER.info("Started to split up sentence into wordList");

        List<String> WordBuffList = new ArrayList<String>();

        for (String word : splitUpSentence(sentence)) {

            WordBuffList.add(word);
        }

        LOGGER.info("Finished to split up sentence into wordList");
        return WordBuffList;
    }


}

