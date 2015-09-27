package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class StartDay(override val code: String) : Codable {
    Dailey("0"),
    Sunday("1"),
    Monday("2"),
    Tuesday("3"),
    Wednesday("4"),
    Thursday("5"),
    Friday("6"),
    Saturday("7"),
    MondayToFriday("8"),
    Weekend("9"),
    Always("A"),
    Never("B")

}

public enum class EndDay(override val code: String) : Codable {
    Sunday("1"),
    Monday("2"),
    Tuesday("3"),
    Wednesday("4"),
    Thursday("5"),
    Friday("6"),
    Saturday("7")
}