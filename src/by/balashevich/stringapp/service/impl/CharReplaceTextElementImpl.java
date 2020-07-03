package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.ReplaceTextElement;

public class CharReplaceTextElementImpl implements ReplaceTextElement {
    private static final String BOUNDARY = "\\b";
    private static final String NUMBER_LETTER = "[\\p{L}-]{%d}";

    @Override
    public String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException {
        if (text == null || position <= 0 || replacement <= 0) {
            throw new ProjectInvalidDataException("Invalid data for replace letter operation");
        }

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i]) || i == 0) {
                if (i + position < chars.length) {
                    int lettersNumber = 0;

                    for (int j = i; j <= i + position; j++) {
                        if (Character.isLetter(chars[j]) || chars[j] == '-') {
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

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == wrongChars[0]) {
                int repetition = 0;

                for (int j = 0; j < wrongChars.length; j++) {
                    if (chars[i + j] == wrongChars[j]) {
                        repetition++;
                    }
                    if (repetition == wrongChars.length && i + replacementChars.length < chars.length) {

                        for (int k = 0; k < replacementChars.length; k++) {
                            chars[i + k] = replacementChars[k];
                        }
                    }
                }
            }
        }

        return String.valueOf(chars);
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
                if (!word.matches(String.format(NUMBER_LETTER, wordLength))) {
                    stringBuilder.append(wordChars);
                } else {
                    stringBuilder.append(replacement);
                }
            }
        }

        return stringBuilder.toString();
    }
}

