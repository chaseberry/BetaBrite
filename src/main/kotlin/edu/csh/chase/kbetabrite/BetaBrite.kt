package edu.csh.chase.kbetabrite

public class BetaBrite {
}

fun stringFromHex(vararg hexes: Int): String {
    val builder = StringBuilder()
    hexes.forEach {
        builder.append(it.toChar())
    }
    return builder.toString()
}