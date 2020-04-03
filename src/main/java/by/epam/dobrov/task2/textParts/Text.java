package by.epam.dobrov.task2.textParts;

import java.util.List;
import java.util.Objects;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class Text {

    private String filePath;
    private List<Paragraph> paragraphList;
    private String text;

    public Text(List<Paragraph> paragraphList) {
        this.paragraphList = paragraphList;

    }

    public Text(String filePath) {
        this.filePath = filePath;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "filePath='" + filePath + '\'' +
                ", paragraphList=" + paragraphList +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return filePath.equals(text1.filePath) &&
                paragraphList.equals(text1.paragraphList) &&
                text.equals(text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, paragraphList, text);
    }
}


