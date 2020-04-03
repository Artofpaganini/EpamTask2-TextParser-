package by.epam.dobrov.task2.textPartsLogic;

import by.epam.dobrov.task2.parser.Parser;
import by.epam.dobrov.task2.textParts.Paragraph;
import by.epam.dobrov.task2.textParts.Sentence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class ParagraphLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParagraphLogic.class);

    private List<String> parseSentenceList;

    public ParagraphLogic(List<String> parseSentenceList) {
        this.parseSentenceList = parseSentenceList;
    }

    public ParagraphLogic() {
    }

    public List<String> getParseSentenceList() { // полученный список предложений использ в getCollectionSentence
        return parseSentenceList;
    }

    public List<Sentence> getCollectionSentence() {
        LOGGER.info("Getting procedure of sentenceList");

        List<Sentence> sentenceBuffList = new ArrayList<>();

        for (String i : getParseSentenceList()) {

            SentenceLogic sentenceLogic = new SentenceLogic(Parser.parseWordListFromSentence(i));
            sentenceBuffList.add(new Sentence(sentenceLogic.getCollectionWords()));
        }

        LOGGER.info("Get sentenceList,which  has  each sentence replaced first and last element ");
        return sentenceBuffList;
    }

    public String getStringFromParagraphLogic(Paragraph paragraph) {
        LOGGER.info("Procedure of constitute paragraph from sentenceList");

        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : paragraph.getSentences()) {

            SentenceLogic sentenceLogic = new SentenceLogic();
            sb.append(sentenceLogic.getStringFromSentenceLogic(sentence)).append(Sentence.SENTENCE_SEPARATOR);
        }
        String paragraphBuff = sb.toString();

        LOGGER.info("Get paragraph");
        return paragraphBuff;
    }

}
