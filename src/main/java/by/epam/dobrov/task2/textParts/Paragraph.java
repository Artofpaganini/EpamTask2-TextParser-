package by.epam.dobrov.task2.textParts;

import java.util.List;
import java.util.Objects;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */

public class Paragraph {

    public static final String PARAGRAPH_SEPARATOR = "\n";

    private List<Sentence> sentences;

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return sentences.equals(paragraph.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }
}
