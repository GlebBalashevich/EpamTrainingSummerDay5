package by.balashevich.stringapp.service.impl;

import by.balashevich.stringapp.exception.ProjectInvalidDataException;
import by.balashevich.stringapp.service.RemoveTextElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRemoveTextElementImpl implements RemoveTextElement {
    private static final String VOWELS = "aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ";
    private static final String SYMBOL_EXCEPT_LETTER = "[^\\p{L}]\\p{Space}?";
    private static final String WORD_CERTAIN_LENGTH = "\\b(\\p{L})\\p{L}{%d}\\b";
    private static final String SPACE = " ";
    private static final String BLANK = "";

    @Override
    public String removeNotLettersSymbols(String text) throws ProjectInvalidDataException {
        if (text == null) {
            throw new ProjectInvalidDataException("Invalid data for remove punctuation operation");
        }

        Pattern pattern = Pattern.compile(SYMBOL_EXCEPT_LETTER);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(SPACE);

        return text;
    }

    @Override
    public String removeWordsCertainLength(String text, int wordLength) throws ProjectInvalidDataException {
        if (text == null || wordLength <= 0) {
            throw new ProjectInvalidDataException("Invalid data for remove word operation");
        }

        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordLength - 1));
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (!VOWELS.contains(matcher.group(1))) {
                matcher.appendReplacement(sb, BLANK);
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
