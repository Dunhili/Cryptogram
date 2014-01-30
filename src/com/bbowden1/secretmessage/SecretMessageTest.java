package com.bbowden1.secretmessage;

import java.util.Arrays;
import java.util.HashMap;
import sofia.util.Random;
import student.TestCase;

/**
 *  Tests the SecretMessage class to ensure that it correctly generates the
 *  cipher text and that the helper methods function correctly.
 *
 *  @author Brian Bowden (bbowden1)
 *  @version Jul 23, 2013
 */
public class SecretMessageTest extends TestCase {
    private SecretMessage message1;
    private SecretMessage message2;
    private SecretMessage message3;
    private SecretMessage message4;

    /**
     * Default Constructor.
     */
    public SecretMessageTest() {
        // initialization should be done in the setUp() method.
    }

    /**
     * Initializes the variables that will be used for the tests.
     */
    public void setUp() {
        Random.setNextInts(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0);
        message1 = new SecretMessage("Test message.");

        Random.setNextInts(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0);
        message2 = new SecretMessage("");

        Random.setNextInts(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0);
        message3 = new SecretMessage("&*(AB .451#@!+. C");

        message4 = new SecretMessage("By Fire Be Purged!");
    }

    /**
     * Tests the mappings for message 1.
     */
    public void testMessage1() {
        int[] charCounts;
        assertEquals("TEST MESSAGE.", message1.getPlainText());
        assertEquals("UFTU NFTTBHF.", message1.getCipherText());
        charCounts = new int[] {0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 1,
            0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(charCounts, message1.getCharacterCounts()));
    }

    /**
     * Tests the mappings for message 2.
     */
    public void testMessage2() {
        assertEquals("", message2.getPlainText());
        assertEquals("", message2.getCipherText());
        int[] charCounts = new int[26];
        assertTrue(Arrays.equals(charCounts, message2.getCharacterCounts()));
    }

    /**
     * Tests the mappings for message 3.
     */
    public void testMessage3() {
        int[] charCounts;
        assertEquals("&*(AB .451#@!+. C", message3.getPlainText());
        assertEquals("&*(BC .451#@!+. D", message3.getCipherText());
        charCounts = new int[] {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(charCounts, message3.getCharacterCounts()));
    }

    /**
     * Tests the mappings for message 4.
     */
    public void testMessage4() {
        assertEquals("BY FIRE BE PURGED!", message4.getPlainText());
    }

    /**
     * Ensures that the hash map has the proper character mapping.
     */
    public void testHashMap() {
        HashMap<Character, Character> charList = message1.getCharacterMapping();
        assertEquals('B', charList.get('A').charValue());
        assertEquals('G', charList.get('F').charValue());
        assertEquals('Y', charList.get('X').charValue());
    }
}
