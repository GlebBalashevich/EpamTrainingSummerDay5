package by.balashevich.stringapp.service;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;

public interface RemoveTextElement {

    public String removeNotLettersSymbols(String text) throws ProjectInvalidDataException;

    public String removeWordsCertainLength(String text, int wordLength) throws ProjectInvalidDataException;
}
