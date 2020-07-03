package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.RemoveTextElement;

public class StringRemoveTextElementImpl implements RemoveTextElement {
    private static final String VOWELS = "aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ";
    private static final String SYMBOL_EXCEPT_LETTER = "[^\\p{L}]\\p{Space}?";
    private static final String BOUNDARY = "\\b";
    private static final String SPACE = " ";

    @Override
    public String removeNotLettersSymbols(String text) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for remove punctuation operation");
        }

        text = text.replaceAll(SYMBOL_EXCEPT_LETTER, SPACE);

        return text;
    }

    @Override
    public String removeWordsCertainLength(String text, int wordLength) throws ProjectInvalidDataException {
        if (text == null || wordLength <= 0) {
            throw new ProjectInvalidDataException("Invalid data for remove word operation");
        }

        StringBuilder builder = new StringBuilder();
        String[] textElements = text.split(BOUNDARY);

        for (String element : textElements) {
            if (element.length() != wordLength) {
                builder.append(element);
            } else {
                if (VOWELS.contains(String.valueOf(element.charAt(0)))) {
                    builder.append(element);
                }
            }
        }

        return builder.toString();
    }
}
