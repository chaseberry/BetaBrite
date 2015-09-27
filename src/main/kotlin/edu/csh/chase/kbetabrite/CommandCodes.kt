package edu.csh.chase.kbetabrite

public enum class CommandCodes(val code: String) {
    WriteText("A"),
    ReadText("B"),
    WriteSpecialFunction("E"),
    ReadSpecialFunction("F"),
    WriteString("G"),
    ReadString("H"),
    WriteSmallDots("I"),
    ReadSmallDots("J"),
    WriteRGBDots("K"),
    ReadRGBDots("L"),
    WriteLargeDots("M"),
    ReadLargeDots("N"),
    WriteAlphaisionBulletin("O"),
    SetTimeout("T");

    override fun toString() = code


}