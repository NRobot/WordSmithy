package com.natecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessWord {
    private final String word;
    private final int wordLength;
    List<Object> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
    private final List<String> syllables = new ArrayList<String>();

    public ProcessWord(String word) {
        this.word = word;
        wordLength = word.length();
        findSyllables(word);
        printResults(syllables);
    }

    private void findSyllables(String word) {
        int syllableCount = 0;
        String newSyllable;
        StringBuilder syllableString = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            if (vowels.contains(word.charAt(i))) {
                syllableString.append(word.charAt(i));
                if (i != 0 && !vowels.contains(word.charAt(i-1)))
                    syllableCount++;
                if (i == 0)
                    syllableCount++;

                if  (i != (wordLength - 1) && !vowels.contains(word.charAt(i+1))) {
                    newSyllable = syllableString.toString();
                    syllables.add((syllableCount - 1), newSyllable);
                    syllableString.setLength(0);
                }
                if  (i == (wordLength - 1)) {
                    newSyllable = syllableString.toString();
                    syllables.add((syllableCount - 1), newSyllable);
                    syllableString.setLength(0);
                }
            }
        }
    }

    private void printResults(List listOfSyllables) {
        int counter = 0;
        int numberOfSyllables = listOfSyllables.size();
        System.out.println("The word: " + word);
        System.out.println("Number of syllables: " + numberOfSyllables);
        if(listOfSyllables !=null) {
            for(Object syllablePrinted : listOfSyllables) {
                counter++;
                System.out.println("Syllable " + counter + ": " + syllablePrinted);
            }
        }
    }
}
