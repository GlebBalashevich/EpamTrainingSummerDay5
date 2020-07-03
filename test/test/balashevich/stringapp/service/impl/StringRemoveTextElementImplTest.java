package test.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.impl.StringRemoveTextElementImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringRemoveTextElementImplTest {
    StringRemoveTextElementImpl removeTextElement;

    @BeforeTest
    public void setUp() {
        removeTextElement = new StringRemoveTextElementImpl();
    }

    @Test(dataProvider = "notLettersDataPositive", dataProviderClass = StaticRemoveTextElementDataProvider.class)
    public void removeNotLettersSymbolsTestPositive(String originalText, String expected) throws ProjectInvalidDataException {
        String actual = removeTextElement.removeNotLettersSymbols(originalText);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "notLettersDataNegative", dataProviderClass = StaticRemoveTextElementDataProvider.class)
    public void removeNotLettersSymbolsTestNegative(String originalText, String expected) throws ProjectInvalidDataException {
        String actual = removeTextElement.removeNotLettersSymbols(originalText);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void removeNotLettersSymbolsTestException() throws ProjectInvalidDataException {
        String actual = removeTextElement.removeNotLettersSymbols(null);
    }

    @Test(dataProvider = "wordsLengthDataPositive", dataProviderClass = StaticRemoveTextElementDataProvider.class)
    public void removeWordsCertainLengthTestPositive(String originalText, int wordLength, String expected) throws ProjectInvalidDataException {
        String actual = removeTextElement.removeWordsCertainLength(originalText, wordLength);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "wordsLengthDataNegative", dataProviderClass = StaticRemoveTextElementDataProvider.class)
    public void removeWordsCertainLengthTestNegative(String originalText, int wordLength, String expected) throws ProjectInvalidDataException {
        String actual = removeTextElement.removeWordsCertainLength(originalText, wordLength);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "wordsLengthDataException",
            dataProviderClass = StaticRemoveTextElementDataProvider.class)
    public void removeWordsCertainLengthTestException(String originalText, int wordLength) throws ProjectInvalidDataException {
        removeTextElement.removeWordsCertainLength(originalText, wordLength);
    }
}