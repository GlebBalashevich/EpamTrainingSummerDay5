package by.balashevich.stringapp.service;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;

public interface RemoveTextElement {

    String removeNotLettersSymbols(String text) throws ProjectInvalidDataException;

    String removeWordsCertainLength(String text, int wordLength) throws ProjectInvalidDataException;
}
