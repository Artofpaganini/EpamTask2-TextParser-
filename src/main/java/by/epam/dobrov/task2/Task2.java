package by.epam.dobrov.task2;

import by.epam.dobrov.task2.parser.Parser;
import by.epam.dobrov.task2.textParts.Text;

import by.epam.dobrov.task2.textPartsLogic.TextLogic;
import by.epam.dobrov.task2.writerService.Writer;


/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class Task2 {

    public static void main(String[] args) {

        String filepath = "file.txt";

        TextLogic textLogic = new TextLogic(Parser.parseParagraphListFromText(filepath));

        Text text = new Text(textLogic.getCollectionParagraph());

        Writer writer = new Writer();

        writer.outputTextInFile(textLogic.getTextFromParagraphList(text));

    }

}
