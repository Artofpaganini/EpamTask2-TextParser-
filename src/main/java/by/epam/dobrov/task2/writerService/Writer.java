package by.epam.dobrov.task2.writerService;

import by.epam.dobrov.task2.textParts.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
 */

public class Writer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    /**
     * Method for writing, edited text in file
     * @see by.epam.dobrov.task2.textPartsLogic.TextLogic#getTextFromParagraphList(Text)
     * @param text
     */
    public void outputTextInFile(String text) {
        LOGGER.info("Started procedure of recording  text  in file, by specified path");

        FileWriter writer;

        {
            try {
                writer = new FileWriter("fileForOutput.txt");

                writer.write(text);

                LOGGER.debug("Finalize the output state by clean all output buffers, procedure of recording is completed");
                writer.flush();

            } catch (IOException e) {
                System.out.println("Check  output parameters ");
                LOGGER.error("File error, recording problem with output  file");
            }

            LOGGER.info("Text parsing complete");
        }

    }
}

