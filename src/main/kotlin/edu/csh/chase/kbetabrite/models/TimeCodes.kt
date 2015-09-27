package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class TimeCodes(override val code: String) : Codable {
    //TODO Maybe add the rest? There are LOTS of them Might user a function
    Always("FF"),
    Never("FE")
}