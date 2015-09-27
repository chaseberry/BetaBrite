package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

enum class FileType(override val code: String) : Codable {
    Text("A"),
    String("B"),
    DotsImage("D")
}