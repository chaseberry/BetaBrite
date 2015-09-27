package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class CommandCodes(override val code: String) : Codable {
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
    SetTimeout("T")
}