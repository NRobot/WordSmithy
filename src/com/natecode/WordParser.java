package com.natecode;

import java.util.Scanner;

// This class will take a string and will parse it to check for problems, remove spaces, and identify features
public class WordParser {
    private String Word;
    private String NewWord;
    private int minWordLength = 3;
    private int maxWordLength = 30;

    private static Scanner scanner = new Scanner(System.in);

    public WordParser() {
        Word = this.getWord();
        System.out.println("The word: " + Word);
    }

    // The initial method that will check to make sure the string is acceptable
    public String getWord() {
        String word;
        while (true) {
            System.out.println("Please enter a word:");
            word = scanner.nextLine();
            if (word.length() >= minWordLength && word.length() <= maxWordLength)
                break;
            System.out.println("Please pick a word between " + minWordLength +
                    " and " + maxWordLength + " in length");
        }
        return word;

    }
}
