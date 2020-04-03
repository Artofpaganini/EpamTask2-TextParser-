package by.epam.dobrov.task2.textPartsLogic;

import by.epam.dobrov.task2.textParts.Sentence;
import by.epam.dobrov.task2.textParts.Word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class SentenceLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentenceLogic.class);

    private List<String> parseWordList;

    public SentenceLogic(List<String> parseWordList) {
        this.parseWordList = parseWordList;
    }

    public List<String> getParseWordList() { // полученный список слов , используется в replaceFirstLastElementInWordList
        return parseWordList;
    }

    public SentenceLogic() {
    }

    public List<String> replaceFirstLastElementInWordList() {
        LOGGER.debug("Started to replace first and last elements");

        Collections.swap(getParseWordList(), 0, getParseWordList().size() - 1);

        LOGGER.info("Finished to replace first and last elements");
        return getParseWordList();
    }

    public List<Word> getCollectionWords() {
        LOGGER.info("Getting procedure of wordList");

        List<Word> wordBuffList = new ArrayList<>();

        for (String i : replaceFirstLastElementInWordList()) {

            Word word = new Word(i);
            wordBuffList.add(word);
        }

        LOGGER.info("Get wordList, which  has replaced first and last element ");
        return wordBuffList;
    }

    public String getStringFromSentenceLogic(Sentence sentence) {
        LOGGER.info("Procedure of constitute sentence from wordList");

        StringBuilder sb = new StringBuilder();

        for (Word word : sentence.getWords()) {

            sb.append(word.getWord()).append(Sentence.SENTENCE_SEPARATOR);
        }
        String sentenceBuff = sb.toString();

        LOGGER.info("Get sentence");
        return sentenceBuff;
    }

}