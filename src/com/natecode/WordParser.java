package com.natecode;

import java.lang.reflect.Array;
import java.util.*;

// This class will take a string and will parse it to check for problems, remove spaces, and identify features
public class WordParser {
    private String word;
    // private String newWord;
    private String firstSyllable;
    int wordLength;

    List<Object> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    List<Object> acceptedChars = Arrays.asList(' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    private static final Scanner scanner = new Scanner(System.in);

    public WordParser() {
        word = this.getWord();
        System.out.println("The word: " + word);
    }

    // Receives string and checks if it is acceptable
    private String getWord() {
        // Receives input from user
        while (true) {
            System.out.println("Please enter a word:");
            word = scanner.nextLine().toLowerCase();
            wordLength = word.length();

            // Checks for acceptable word length
            int maxWordLength = 25;
            int minWordLength = 3;
            if(checkLength(word, minWordLength, maxWordLength)) {
                // Checks for allowed characters
                if(checkCharacters(word))
                    // Checks to make sure there are vowels
                    if (checkVowels(word))
                    break;
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

    private void findSyllables(String word) {
        StringBuilder syllable = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            if (vowels.contains(word.charAt(i))) {
                syllable.append(word.charAt(i));
                break;
            }
			else if  (i != (wordLength - 1) && !vowels.contains(word.charAt(i+1)))
                break;
        }

        System.out.println("First syllable is \"" + syllable + "\".");
    }
}
