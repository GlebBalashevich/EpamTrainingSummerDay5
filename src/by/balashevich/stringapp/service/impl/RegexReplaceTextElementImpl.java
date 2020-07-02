package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.ReplaceTextElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplaceTextElementImpl implements ReplaceTextElement {
    private static final String WORD_CERTAIN_LENGTH = "\\b\\p{L}{%d}\\b";
    private static final String ORDINAL_LETTER = "\\b(\\p{L}{%d})(\\p{L})(\\p{L}*)";
    private static final String REPLACE_GROUP = "$1%s$3";


    @Override
    public String replaceLetters(String text, int position, char replacement) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for replace letter operation");
        }

        Pattern pattern = Pattern.compile(String.format(ORDINAL_LETTER, position - 1));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(String.format(REPLACE_GROUP, replacement));

        return text;
    }

    @Override
    public String replaceWrongElements(String text, String wrongElement, String replacement) throws ProjectInvalidDataException {
        if (text == null || wrongElement == null || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace wrong element operation");
        }

        Pattern pattern = Pattern.compile(wrongElement);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(replacement);

        return text;
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String replacement) throws ProjectInvalidDataException {
        if (text == null || replacement == null) {
            throw new ProjectInvalidDataException("Invalid data for replace word on substring operation");
        }

        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(replacement);

        return text;
    }
}
