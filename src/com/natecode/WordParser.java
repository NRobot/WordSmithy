package com.natecode;

import java.util.*;

// This class will take a string and will parse it to check for problems.
public class WordParser {
    private String word;
    // private String newWord;
    private int wordLength;
    private String wordEnding;

    List<Object> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
    List<Object> acceptedChars = Arrays.asList(' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    List<Object> endConsonantList = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z');
    List<Object> wordEndingList = Arrays.asList("le", "el", "ing", "ly", "al", "ful", "less", "ive", "ous");

    private static final Scanner scanner = new Scanner(System.in);

    public WordParser() {
        word = this.getWord();
        ProcessWord processNewWord = new ProcessWord(word);
    }

    // Receives string and checks if it is acceptable
    private String getWord() {
        // Receives input from user
        while (true) {
            System.out.println("Please enter a word:");
            word = scanner.nextLine().toLowerCase().trim();
            wordLength = word.length();

            // Checks for acceptable word length
            int maxWordLength = 25;
            int minWordLength = 3;
            if(checkLength(word, minWordLength, maxWordLength)) {
                // Checks for allowed characters
                if(checkCharacters(word))
                    // Checks to make sure there are vowels
                    if (checkVowels(word)) {
                        break;
                    }
                ;
            };
        }
        return word;
    }

    private boolean checkLength (String word, int minLength, int maxLength) {
        boolean correctLength = false;

        if (wordLength >= minLength && wordLength <= maxLength)
            correctLength = true;
        else {
            System.out.println("Please pick a word between " + minLength +
                    " and " + maxLength + " characters in length...");
        }
        return correctLength;
    }

    private boolean checkCharacters (String word) {
        boolean correctCharacters = false;

        for (int i = 0; i < wordLength; i++) {
            if (acceptedChars.contains(word.charAt(i)))
                correctCharacters = true;
            else {
                correctCharacters = false;
                break;
            }
        }

        if (!correctCharacters)
            System.out.println("Please only use a-z and spaces...");

        return correctCharacters;
    }

    private boolean checkVowels (String word) {
        boolean vowelFound = false;

        for (int i = 0; i < wordLength; i++) {
            if (vowels.contains(word.charAt(i))) {
                vowelFound = true;
                break;
            }
        }

        if (!vowelFound)
            System.out.println("Looks like you don't have any vowels...");

        return vowelFound;
    }
}
