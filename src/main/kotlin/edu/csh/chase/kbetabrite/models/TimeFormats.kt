package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

enum class TimeFormat(override val code: String) : Codable {
    TwelveHour("S"),
    TwentyFourHour("M")
}