package test.balashevich.stringapp.service.impl;

import org.testng.annotations.DataProvider;

public class StaticRemoveTextElementDataProvider {
    static String originalText = "HI!!! I want to ask you: \"How are you, when you are born, in 20th century?\".\n" +
            "I'm live in Minsk. But where living you: Mogilev, Brest or in Minsk too?....";

    @DataProvider(name = "notLettersDataPositive")
    public static Object[][] createNotLettersDataPositive() {
        return new Object[][]{
                {originalText, "HI I want to ask you How are you when you are born in th century\n" +
                        "I m live in Minsk But where living you Mogilev Brest or in Minsk too" }
        };
    }

    @DataProvider(name = "notLettersDataNegative")
    public static Object[][] createNotLettersDataNegative() {
        return new Object[][]{
                {"pop-up", "popup" },
                {"2020327", "2020327" },
                {"hello world", "helloworld" },
        };
    }

    @DataProvider(name = "wordsLengthDataPositive")
    public static Object[][] createWordsLengthDataPositive() {
        return new Object[][]{
                {originalText, 3, "HI!!! I want to ask you: \" are you, when you are born, in 20th century?\".\n" +
                        "I'm live in Minsk.  where living you: Mogilev, Brest or in Minsk ?...." }
        };
    }

    @DataProvider(name = "wordsLengthDataException")
    public static Object[][] createWordsLengthDataException() {
        return new Object[][]{
                {null, 3},
                {"Hi", -1}
        };
    }

    @DataProvider(name = "wordsLengthDataNegative")
    public static Object[][] createWordsLengthDataNegative() {
        return new Object[][]{
                {"You are your only limit.", 3, "  your only limit" },
                {"You are your only limit.", 6, "You are your only " },
                {"Money often costs too much", 6, " often  too much" },
        };
    }
}
