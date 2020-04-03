package by.epam.dobrov.task2.textParts;

import java.util.Objects;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения
 */
public class Word {

    public final static String WORDS_SEPARATOR = " ";

    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}


