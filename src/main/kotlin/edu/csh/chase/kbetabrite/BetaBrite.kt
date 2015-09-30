package edu.csh.chase.kbetabrite

import java.util.*

fun commands(vararg commands: Command): ArrayList<Command> {
    val list = ArrayList<Command>()
    list.addAll(commands)
    return list
}