package by.balashevich.stringapp.reader;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextDataReader {
    private static final String DEFAULT_PATH = "input/textData.txt";

    public String readFileData(String filename) throws ProjectInvalidDataException {
        Path path = Paths.get(DEFAULT_PATH);
        String stringData;

        if (filename != null) {
            if (Files.exists(Paths.get(filename))) {
                path = Paths.get(filename);
            }
        }

        try {
            stringData = Files.readString(path);
        } catch (IOException e) {
            throw new ProjectInvalidDataException("Exception while opening file", e);
        }

        return stringData;
    }

    public String readConsoleData() throws ProjectInvalidDataException {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("to stop entering text please write: stopEnter");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String lineValue;

            while (true) {
                lineValue = reader.readLine();

                if (lineValue.equals("stopEnter")) {
                    break;
                } else {
                    stringBuilder.append(lineValue);
                }
            }
        } catch (IOException e) {
            throw new ProjectInvalidDataException("Exception while reading data from console", e);
        }

        return stringBuilder.toString();
    }
}
