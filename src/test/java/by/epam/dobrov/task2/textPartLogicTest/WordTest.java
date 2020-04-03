package by.epam.dobrov.task2.textPartLogicTest;

import by.epam.dobrov.task2.textPartsLogic.SentenceLogic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordTest {

    private SentenceLogic sentenceLogic;

    @Before
    public void createNewSentenceLogic() {
        List<String> actualWordList = new ArrayList<String>();

        actualWordList.add("Мама");
        actualWordList.add("мыла");
        actualWordList.add("раму");

        sentenceLogic = new SentenceLogic(actualWordList);

    }

    @Test
    public void newActualList_ShouldReplaceFirstLastElementAndEqualsExpectedList() {

        List<String> expectedWordList = new ArrayList<String>();

        expectedWordList.add("раму");
        expectedWordList.add("мыла");
        expectedWordList.add("Мама");

        sentenceLogic.replaceFirstLastElementInWordList();
        Assert.assertEquals(expectedWordList, sentenceLogic.getParseWordList());

    }
}
