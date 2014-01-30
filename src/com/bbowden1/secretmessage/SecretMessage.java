package com.bbowden1.secretmessage;

import java.util.Locale;
import java.util.ArrayList;
import java.util.HashMap;
import sofia.util.Random;

/**
 *  Immutable class that takes in a message and creates a corresponding cipher
 *  text. Has helper methods as well that can also be used for the cryptogram.
 *
 *  @author Brian Bowden (bbowden1)
 *  @version Jul 23, 2013
 */
public class SecretMessage {
    /**
     * Number of characters that will be used for the cryptogram (note that
     * special characters, spaces, and punctuation are not counted).
     */
    final static int NUMBER_CHARACTERS = 26;

    private String plainText;
    private String cipherText;
    private HashMap<Character, Character> charMap;

    /**
     * Comprehensive constructor, initializes the data structures and creates
     * the changed message.
     *
     * @param plainText original String for the Cryptogram
     */
    public SecretMessage(String plainText) {
        this.plainText = plainText.toUpperCase(Locale.US);
        charMap = new HashMap<Character, Character>(NUMBER_CHARACTERS * 2);
        generateMapping();
        generateCipherText();
    }

    /**
     * Returns the original String.
     *
     * @return original, unmodified String
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * Returns the modified String.
     *
     * @return cryptogram String
     */
    public String getCipherText() {
        return cipherText;
    }

    /**
     * Returns the number of occurrences of each letter in the modified String.
     * Index 0 will be 'A', 1 will be 'B', etc.
     *
     * @return array containing the number of occurrences of each character
     */
    public int[] getCharacterCounts() {
        int[] charCount = new int[NUMBER_CHARACTERS];
        int index;

        for (int i = 0; i < cipherText.length(); i++) {
            index = cipherText.charAt(i) - 'A';
            if (index >= 0 && index < NUMBER_CHARACTERS) {
                ++charCount[index];
            }
        }
        return charCount;
    }

    /**
     * Returns the hash map that corresponds to the character mappings where the
     * key is the original character and the value is the changed character.
     *
     * @return hash map containing the character mappings
     */
    public HashMap<Character, Character> getCharacterMapping() {
        return charMap;
    }

    /**
     * Creates the hash map. Ensures that characters don't map to themselves
     * ie. 'A' won't map to 'A'.
     */
    private void generateMapping() {
        ArrayList<Character> characterSet =
            new ArrayList<Character>(NUMBER_CHARACTERS);
        for (int i = 0; i < NUMBER_CHARACTERS; i++) {
            characterSet.add((char) ('A' + i));
        }

        Random rand = new Random();
        int index = 0;
        int i = 0;
        char currentLetter;
        while (i < NUMBER_CHARACTERS) {
            currentLetter = (char) ('A' + i);
            index = rand.nextInt(characterSet.size());
            if (currentLetter != characterSet.get(index)) {
                charMap.put(currentLetter, characterSet.get(index));
                characterSet.remove(index);
                ++i;
            }
        }
    }

    /**
     * Changes the original String into the modified String for the
     * cryptogram.
     */
    private void generateCipherText() {
        StringBuffer strBuffer = new StringBuffer(plainText.length());
        for (int i = 0; i < plainText.length(); i++) {
            if (charMap.containsKey(plainText.charAt(i))) {
                strBuffer.append(charMap.get(plainText.charAt(i)));
            }
            else {
                strBuffer.append(plainText.charAt(i));
            }
        }
        cipherText = strBuffer.toString();
    }
}
