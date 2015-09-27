package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class ColorCodes(override val code: String) : Codable {
    Monochrome("1000"),
    ThreeColor("2000"),
    EightColor("4000")
}
