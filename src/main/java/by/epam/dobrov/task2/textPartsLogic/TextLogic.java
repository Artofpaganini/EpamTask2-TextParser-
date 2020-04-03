package by.epam.dobrov.task2.textPartsLogic;

import by.epam.dobrov.task2.parser.Parser;

import by.epam.dobrov.task2.textParts.Paragraph;
import by.epam.dobrov.task2.textParts.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class TextLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextLogic.class);

    private List<String> parseParagraphList;

    public TextLogic(List<String> parseParagraphList) {
        this.parseParagraphList = parseParagraphList;
    }

    public List<String> getParseParagraphList() { // полученный список  параграфов  исп в getCollectionParagraph
        return parseParagraphList;
    }

    /**
     * getting a list, type (Paragraph)
     * @see Parser#parseParagraphListFromText(String)
     * @return edited paragraphList
     */
    public List<Paragraph> getCollectionParagraph() {
        LOGGER.info("Getting procedure of paragraphList");

        List<Paragraph> paragraphBuffList = new ArrayList<>();

        for (String i : getParseParagraphList()) {

            ParagraphLogic paragraphLogic = new ParagraphLogic(Parser.parseSentenceListFromParagraph(i));

            paragraphBuffList.add(new Paragraph(paragraphLogic.getCollectionSentence()));
        }

        LOGGER.info("Get paragraphList");
        return paragraphBuffList;
    }

    /**
     *
     * @param text
     * @see TextLogic#getCollectionParagraph()
     * @return text
     */
    public String getTextFromParagraphList(Text text) {
        LOGGER.info("Procedure of constitute text from paragraphList");

        StringBuilder sb = new StringBuilder();

        for (Paragraph paragraph : text.getParagraphList()) {

            ParagraphLogic paragraphLogic = new ParagraphLogic();
            sb.append(paragraphLogic.getStringFromParagraphLogic(paragraph)).append(Paragraph.PARAGRAPH_SEPARATOR);

        }
        String textBuff = sb.toString();

        LOGGER.info("Get text");
        return textBuff;
    }
}





