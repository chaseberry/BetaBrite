package edu.csh.chase.kbetabrite.constants

import edu.csh.chase.kbetabrite.Codable

enum class KeyboardProtectionStatus(override val code: String) : Codable {
    Unlocked("U"),
    Locked("L")
}