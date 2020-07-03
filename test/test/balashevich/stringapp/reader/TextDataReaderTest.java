package test.balashevich.stringapp.reader;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.reader.TextDataReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.*;

public class TextDataReaderTest {
    TextDataReader textDataReader;

    @BeforeTest
    public void setUp() {
        textDataReader = new TextDataReader();
    }

    @Test
    public void testReadConsoleData() throws ProjectInvalidDataException {
        StringBuilder sb = new StringBuilder();
        sb.append("Do something with passion or not it all\n");
        sb.append("stopEnter");

        try (InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes())) {
            InputStream defaultInputStream = System.in;
            System.setIn(inputStream);

            String expected = "Do something with passion or not it all";
            String actual = textDataReader.readConsoleData();
            assertEquals(actual, expected);

            System.setIn(defaultInputStream);
        } catch (IOException e) {
            fail("Error while read data from pseudo console");
        }
    }
}