package edu.csh.chase.kbetabrite.models

//TODO add the rest of these
public enum class SignCodes(code: Char) {
    VisualVerification('!'),
    SerialClock('"'),
    AlphaVisionSign('#'),
    FullMatrixAlphaVisionSign('$'),
    AllSigns('Z')//Lets be honest this is the only one we use
}