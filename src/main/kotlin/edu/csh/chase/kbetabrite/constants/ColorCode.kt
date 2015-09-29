package edu.csh.chase.kbetabrite.constants

import edu.csh.chase.kbetabrite.Codable

public enum class ColorCode(override val code: String) : Codable {
    Monochrome("1000"),
    ThreeColor("2000"),
    EightColor("4000")
}
