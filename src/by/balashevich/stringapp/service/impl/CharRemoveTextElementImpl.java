package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.RemoveTextElement;

public class CharRemoveTextElementImpl implements RemoveTextElement {
    private static final String SPACE = " ";
    private static final String BOUNDARY = "\\b";
    private static final String NUMBER_LETTERS = "[\\p{L}|\\-]{%d}";
    private static final String VOWELS = "aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ";


    @Override
    public String removeNotLettersSymbols(String text) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for remove word operation");
        }

        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i]) || Character.isWhitespace(chars[i])) {
                stringBuilder.append(chars[i]);
            } else {
                if (i - 1 >= 0 && i + 1 < chars.length) {
                    if (Character.isLetter(chars[i - 1]) && Character.isLetter(chars[i + 1])) {
                        stringBuilder.append(SPACE);
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String removeWordsCertainLength(String text, int wordLength) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for remove word operation");
        }

        String[] words = text.split(BOUNDARY);
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (wordChars.length != wordLength) {
                stringBuilder.append(wordChars);
            } else {
                if (!word.matches(String.format(NUMBER_LETTERS, wordLength))) {
                    stringBuilder.append(wordChars);
                } else {
                    if (VOWELS.contains(String.valueOf(wordChars[0]))) {
                        stringBuilder.append(wordChars);
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
