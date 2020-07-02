package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.ReplaceTextElement;

public class StringReplaceTextElementImpl implements ReplaceTextElement {
    private static final String BOUNDARY = "\\b";
    private static final String LETTER = "\\p{L}+";

    @Override
    public String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for replace letter operation");
        }

        String[] words = text.split(BOUNDARY);

        for (String word : words) {
            if (word.length() >= position && word.matches(LETTER)) {
                String modifiedWord = word.substring(0, position - 1) + replacement + word.substring(position);
                text = text.replace(word, modifiedWord);
            }
        }

        return text;
    }

    @Override
    public String replaceWrongElements(String text, String wrongElement, String replacement) throws ProjectInvalidDataException {
        if (text == null || wrongElement == null || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace wrong element operation");
        }

        text = text.replace(wrongElement, replacement);

        return text;
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String replacement) throws ProjectInvalidDataException {
        if (text == null || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace word on substring operation");
        }

        String[] words = text.split(BOUNDARY);

        for (String word : words) {
            if (word.length() == wordLength && word.matches(LETTER)) {
                text = text.replace(word, replacement);
            }
        }

        return text;
    }
}
