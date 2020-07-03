package test.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.impl.StringReplaceTextElementImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringReplaceTextElementImplTest {
    StringReplaceTextElementImpl replaceTextElement;

    @BeforeTest
    public void setUp() {
        replaceTextElement = new StringReplaceTextElementImpl();
    }

    @Test(dataProvider = "letterDataPositive", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceLettersTestPositive(String originalText, int position, char replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceLetters(originalText, position, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "letterDataNegative", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceLettersTestNegative(String originalText, int position, char replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceLetters(originalText, position, replacement);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "letterDataException",
            dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceLettersTestException(String originalText, int position, char replacement) throws ProjectInvalidDataException {
        replaceTextElement.replaceLetters(originalText, position, replacement);

    }

    @Test(dataProvider = "wrongElementsDataPositive", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWrongElementsTestPositive(String originalText, String wrongElement,
                                                 String replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceWrongElements(originalText, wrongElement, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "wrongElementsDataNegative", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWrongElementsTestNegative(String originalText, String wrongElement,
                                                 String replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceWrongElements(originalText, wrongElement, replacement);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "wrongElementsDataException",
            dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWrongElementsTestException(String originalText, String wrongElement,
                                                  String replacement) throws ProjectInvalidDataException {
        replaceTextElement.replaceWrongElements(originalText, wrongElement, replacement);
    }

    @Test(dataProvider = "wordsOnSubstringDataPositive", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWordsOnSubstringTestPositive(String originalText, int wordLength,
                                                    String replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceWordsOnSubstring(originalText, wordLength, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "wordsOnSubstringDataNegative", dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWordsOnSubstringTestNegative(String originalText, int wordLength,
                                                    String replacement, String expected) throws ProjectInvalidDataException {
        String actual = replaceTextElement.replaceWordsOnSubstring(originalText, wordLength, replacement);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "wordsOnSubstringDataException",
            dataProviderClass = StaticReplaceTextElementDataProvider.class)
    public void replaceWordsOnSubstringTestException(String originalText, int wordLength,
                                                     String replacement) throws ProjectInvalidDataException {
        replaceTextElement.replaceWordsOnSubstring(originalText, wordLength, replacement);
    }
}