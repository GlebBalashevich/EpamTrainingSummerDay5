package by.balashevich.stringapp.service;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;

public interface ReplaceTextElement {

    public String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException;

    public String replaceWrongElements(String text, String wrongElement, String replacement) throws ProjectInvalidDataException;

    public String replaceWordsOnSubstring(String text, int wordLength, String replacement) throws ProjectInvalidDataException;
}
