package com.natecode;

import java.util.Scanner;

// This class will take a string and will parse it to check for problems, remove spaces, and identify features
public class WordParser {
    private String word;
    private String newWord;
    private int minWordLength = 3;
    private int maxWordLength = 25;
    int wordLength;

    private static Scanner scanner = new Scanner(System.in);

    public WordParser() {
        word = this.getWord();
        System.out.println("The word: " + word);
    }

    // The initial method that will check to make sure the string is acceptable
    public String getWord() {

        while (true) {
            System.out.println("Please enter a word:");
            word = scanner.nextLine();
            wordLength = word.length();

            firstIf:
            if (word.length() >= minWordLength && word.length() <= maxWordLength) {
                if(checkVowels(word) == true)
                break;
            }
            else
            System.out.println("Please pick a word between " + minWordLength +
                    " and " + maxWordLength + " characters in length");
        }
        return word;
    }

    public boolean checkVowels(String word) {
        String vowels = "aeiou";
        boolean vowelFound = false;

        outerloop:
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if (word.charAt(i) == vowels.charAt(j)) {
                    vowelFound = true;
                    break outerloop;
                }
            }
        }
        if (vowelFound == false)
            System.out.println("Looks like you don't have any vowels.");
        return vowelFound;
    }

    public boolean checkNumbers(String word) {
        String numbers = "0123456789";
        boolean numberFound = false;

        outerloop:
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < numbers.length(); j++) {
                if (word.charAt(i) == numbers.charAt(j)) {
                    numberFound = true;
                    break outerloop;
                }
            }
        }
        if (numberFound == true)
            System.out.println("Please don't include any numbers.");
        return numberFound;
    }

}
