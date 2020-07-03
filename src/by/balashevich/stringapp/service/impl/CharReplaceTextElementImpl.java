package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.ReplaceTextElement;

import java.util.Arrays;

public class CharReplaceTextElementImpl implements ReplaceTextElement {
    private static final String BOUNDARY = "\\b";
    private static final String COUNT_LETTERS = "\\p{L}{%d}";

    @Override
    public String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException {
        if (text == null || position <= 0) {
            throw new ProjectInvalidDataException("Invalid data for replace letter operation");
        }

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetterOrDigit(chars[i]) || i == 0) {
                if (i + position < chars.length) {
                    int lettersNumber = 0;

                    for (int j = i; j <= i + position; j++) {
                        if (Character.isLetter(chars[j])) {
                            lettersNumber++;
                        }
                        if (lettersNumber == position) {
                            chars[j] = replacement;
                        }
                    }
                }
            }
        }

        return String.valueOf(chars);
    }

    @Override
    public String replaceWrongElements(String text, String wrongElement, String replacement) throws ProjectInvalidDataException {
        if (text == null || wrongElement == null || wrongElement.length() < 1 || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace wrong element operation");
        }

        char[] chars = text.toCharArray();
        char[] wrongChars = wrongElement.toCharArray();
        char[] replacementChars = replacement.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        while (index < chars.length) {
            if (chars[index] == wrongChars[0] && (index + wrongChars.length) <= chars.length) {
                char[] compareArray = Arrays.copyOfRange(chars, index, index + wrongChars.length);
                if (Arrays.equals(compareArray, wrongChars)) {
                    stringBuilder.append(replacementChars);
                    index += wrongChars.length;
                } else {
                    stringBuilder.append(chars[index]);
                    index++;
                }
            } else {
                stringBuilder.append(chars[index]);
                index++;
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String replacement) throws ProjectInvalidDataException {
        if (text == null || wordLength <= 0 || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace word on substring operation");
        }

        String[] words = text.split(BOUNDARY);
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (wordChars.length != wordLength) {
                stringBuilder.append(wordChars);
            } else {
                if (!word.matches(String.format(COUNT_LETTERS, wordLength))) {
                    stringBuilder.append(wordChars);
                } else {
                    stringBuilder.append(replacement);
                }
            }
        }

        return stringBuilder.toString();
    }
}

