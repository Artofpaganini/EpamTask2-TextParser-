package by.epam.dobrov.task2.parser;

import by.epam.dobrov.task2.textParts.Text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ParserTest {

    private Text text;


    @Before
    public void createParser() {
        text = new Text("file.txt");

    }

    @Test
    public void newParagraph_ShouldNotNull() {

        String line = "123";

        Assert.assertTrue(Parser.isLineReaderNotNull(line));
    }

    @Test
    public void newParagraph_ShouldBeNull() {

        String line = null;

        Assert.assertFalse(Parser.isLineReaderNotNull(line));
    }

    @Test(expected = FileNotFoundException.class)
    public void newFile_ShouldHasWrongFilePath() throws FileNotFoundException {

        text.setFilePath("file1.txt");

        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(text.getFilePath())));

    }

    @Test
    public void newSentenceList_ShouldBeCreateFromParagraph() {

        String stringLine = "123. 456. 789.";

        List<String> expectedList = new ArrayList<>();
        expectedList.add("123.");
        expectedList.add("456.");
        expectedList.add("789.");

        List<String> actualList = Parser.parseSentenceListFromParagraph(stringLine);

        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void newWordList_ShouldBeCreateFromSentence() {

        String stringLine = "Note: To better understand this concepts.";

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Note:");
        expectedList.add("To");
        expectedList.add("better");
        expectedList.add("understand");
        expectedList.add("this");
        expectedList.add("concepts.");

        List<String> actualList = Parser.parseWordListFromSentence(stringLine);

        Assert.assertEquals(expectedList, actualList);

    }
}



