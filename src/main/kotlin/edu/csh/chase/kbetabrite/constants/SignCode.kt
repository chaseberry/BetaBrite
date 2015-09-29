package edu.csh.chase.kbetabrite.constants

import edu.csh.chase.kbetabrite.Codable

//TODO add the rest of these
public enum class SignCode(override val code: String) : Codable {
    VisualVerification("!"),
    SerialClock("\""),
    AlphaVisionSign("#"),
    FullMatrixAlphaVisionSign("$"),
    AllSigns("Z")//Lets be honest this is the only one we use
}