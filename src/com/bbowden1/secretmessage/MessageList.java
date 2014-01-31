package com.bbowden1.secretmessage;

//-------------------------------------------------------------------------
/**
*  Contains the list of the possible messages.
*
*  @author Brian Bowden
*  @version 1/30/2014
*/
public class MessageList
{
    private MessageList() {
        // Doesn't need to be initialized
    }

    /** Contains the list of the messages */
    public final static String list[] = {
        "You have brains in your head. You have feet in your shoes. You can steer yourself in any direction you choose. You're on your own, and you know what you know. And you are the guy who'll decide where to go.",
        "Deep into that darkness peering, long I stood there, wondering, fearing, doubting, dreaming dreams no mortal ever dared to dream before.",
        "Wise men speak because they have something to say; Fools because they have to say something.",
        "Half the world is composed of people who have something to say and can't, and the other half who have nothing to say and keep on saying it."
    };

    /** Contains the list of the corresponding authors for the messages */
    public final static String author[] = {
        "Dr. Seuss",
        "Edgar Allan Poe",
        "Plato",
        "Robert Frost"
    };
}
