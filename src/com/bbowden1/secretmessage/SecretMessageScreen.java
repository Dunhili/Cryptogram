package com.bbowden1.secretmessage;

import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 *  Creates the GUI for the Cryptogram game.
 *
 *  @author Brian Bowden (bbowden1)
 *  @version Aug 2, 2013
 */
public class SecretMessageScreen extends ShapeScreen {
    private int numberCharactersPerLine;

    public void initialize() {
        numberCharactersPerLine = (int) (getWidth() / 50);

    }
}
