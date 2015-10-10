package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import edu.csh.chase.kbetabrite.constants.displayModeFromString
import edu.csh.chase.kbetabrite.models.Text
import java.util.*

class Test {

    val scanner = Scanner(System.`in`)

    public fun main(args: Array<String>) {
        val packet = Packet(outFile = "/dev/ttyUSB0")

        while (true) {
            printMenu()
            val i = scanner.nextLine()
            when (i[0]) {
                'c' -> packet.commands.clear()
                't' -> addText(packet)
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

    private fun addText(packet: Packet) {
        println("Text")
        val text = scanner.nextLine()
        println("Mode")
        val mode = scanner.nextLine()
        println("File")
        val file = scanner.nextInt()
        packet.commands.add(WriteText(fileIndex = file,
                texts = Text(text = text,
                        mode = displayModeFromString(mode),
                        displayPosition = DisplayPosition.Fill)))
    }
}
