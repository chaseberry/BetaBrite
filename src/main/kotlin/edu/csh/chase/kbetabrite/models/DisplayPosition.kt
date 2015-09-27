package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class DisplayPosition(override val code: String) : Codable {
    MiddleLine(" "),
    TopLine("\""),
    BottomLine("&"),
    Fill("0"),
    Left("1"),
    Right("2")
}