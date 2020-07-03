package test.balashevich.stringapp.service.impl;

import org.testng.annotations.DataProvider;

public class StaticReplaceTextElementDataProvider {

    @DataProvider(name = "letterDataPositive")
    public static Object[][] createLetterDataPositive() {
        return new Object[][]{
                {"Hello, my name is Java", 3, 'X', "HeXlo, my naXe is JaXa" },
                {"First, Second, 3rd", 1, 'X', "Xirst, Xecond, 3rd" }
        };
    }

    @DataProvider(name = "letterDataNegative")
    public static Object[][] createLetterDataNegative() {
        return new Object[][]{
                {"Hello, my name is Java", 3, 'X', "HeXlo, myX naXe isX JaXa" },
                {"123", 3, 'X', "12X" },
                {"S2000", 3, 'X', "S2X00" }
        };
    }

    @DataProvider(name = "letterDataException")
    public static Object[][] createLetterDataException() {
        return new Object[][]{
                {null, 3, 'x'},
                {"HI", 0, 'x'},
        };
    }

    @DataProvider(name = "wrongElementsDataPositive")
    public static Object[][] createWrongElementsDataPositive() {
        return new Object[][]{
                {"Hello, lolli,lololi", "lo", "ra", "Helra, ralli,rarali" },
        };
    }

    @DataProvider(name = "wrongElementsDataNegative")
    public static Object[][] createWrongElementsDataNegative() {
        return new Object[][]{
                {"Hello, LOlli,loLOli", "lo", "ra", "Helra, ralli,rarali" },
                {"Hello, lli,lolil", "lo", "ra", "Helra, lli,ralira" },
        };
    }

    @DataProvider(name = "wrongElementsDataException")
    public static Object[][] createWrongElementsDataException() {
        return new Object[][]{
                {null, "li", "luk" },
                {"HI", null, "luk" },
                {"HI", "li", null}
        };
    }

    @DataProvider(name = "wordsOnSubstringDataPositive")
    public static Object[][] createWordsOnSubstringDataPositive() {
        return new Object[][]{
                {"It's new vision of SRP in non digit area", 3, "XXXX",
                        "It's XXXX vision of XXXX in XXXX digit area" },
        };
    }

    @DataProvider(name = "wordsOnSubstringDataNegative")
    public static Object[][] createWordsOnSubstringDataNegative() {
        return new Object[][]{
                {"the war ended in 1945", 4, "XXXX", "the war ended in XXXX" },
                {"the 2nd war ended in 1945", 3, "XXXX", "XXXX XXXX XXXX ended in 1945" },
                {"the 2nd war ended in 1945", 1, "XXXX", "XXXX 2XXXX XXXX XXXX XXXX 1945" },
        };
    }

    @DataProvider(name = "wordsOnSubstringDataException")
    public static Object[][] createWordsOnSubstringDataException() {
        return new Object[][]{
                {null, 1, "luk" },
                {"HI", -1, "luk" },
                {"HI", 3, null}
        };
    }
}
