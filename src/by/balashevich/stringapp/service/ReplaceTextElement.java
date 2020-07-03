package by.balashevich.stringapp.service;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;

public interface ReplaceTextElement {

    String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException;

    String replaceWrongElements(String text, String wrongElement, String replacement) throws ProjectInvalidDataException;

    String replaceWordsOnSubstring(String text, int wordLength, String replacement) throws ProjectInvalidDataException;
}
