package com.naterobot;

import java.util.*;

public class ProcessWord {
    private final String wordEntered;
    private final int wordLength;
    List<Object> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
    private final List<String> vowelsFromWord = new ArrayList<>();

    public ProcessWord(String word) {
        this.wordEntered = word;
        wordLength = word.length();
        findSyllables(word);
        printResults(vowelsFromWord);
        newVowels(vowelsFromWord);
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
                    vowelsFromWord.add((syllableCount - 1), newSyllable);
                    syllableString.setLength(0);
                }
                if  (i == (wordLength - 1)) {
                    newSyllable = syllableString.toString();
                    vowelsFromWord.add((syllableCount - 1), newSyllable);
                    syllableString.setLength(0);
                }
            }
        }
    }

    private void newVowels(List listOfVowelStrings) {
            Map<String, Object> newVowelGroups = new HashMap<String, Object>();

        // Initial set of alternatives
        newVowelGroups.put("u", "oo");
        newVowelGroups.put("oo", "u");
        newVowelGroups.put("e", "i");
        newVowelGroups.put("ea", "ee");
        newVowelGroups.put("i", "u");

        // Numbers
        newVowelGroups.put("o", "0");
        // mapOfOptions.put("i", "1");
        newVowelGroups.put("z", "2");
        newVowelGroups.put("s", "$");
        newVowelGroups.put("h", "#");
        newVowelGroups.put("a", "@");
        newVowelGroups.put("e", "");

        if(listOfVowelStrings !=null) {
            String newWordSpelling = "If you are reading this, something went wrong";
            String oldSubString;
            String newSubString;

            for(Object syllable : listOfVowelStrings) {

                for (Map.Entry<String, Object> entry :newVowelGroups.entrySet()) {
                    if(syllable.toString().equals(entry.getKey())) {
                        oldSubString = syllable.toString();
                        newSubString = entry.getValue().toString();
                        newWordSpelling = wordEntered.replace(oldSubString, newSubString);
                        System.out.println("New version of word: " + newWordSpelling);
                    }
                }
            }
        }



    }

    private void printResults(List listOfSyllables) {
        int counter = 0;
        int numberOfSyllables = listOfSyllables.size();
        System.out.println("The word: " + wordEntered);
        System.out.println("Number of syllables: " + numberOfSyllables);
        if(listOfSyllables !=null) {
            for(Object syllablePrinted : listOfSyllables) {
                counter++;
                System.out.println("Syllable " + counter + ": " + syllablePrinted);
            }
        }
    }
}
