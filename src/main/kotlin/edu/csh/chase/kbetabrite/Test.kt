package edu.csh.chase.kbetabrite

import java.util.*

class Test {

    public fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val packet = Packet(outFile = "/dev/ttyUSB0")

        while (true) {
            printMenu()
            val i = scanner.nextLine()
            when (i[0]) {
                'p' -> packet.commands.clear()
                'q' -> System.exit(0)
            }
        }
    }

    private fun printMenu() {
        println("*******************")
        println("* Clear Packet: c *")
        println("* Text: t         *")
        println("* String: s       *")
        println("* Picture: p      *")
        println("* Quit: q         *")
        println("*******************")
    }
}
