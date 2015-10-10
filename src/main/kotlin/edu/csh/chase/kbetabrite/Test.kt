package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.commands.SetMemoryConfig
import edu.csh.chase.kbetabrite.commands.WriteString
import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.constants.ColorCode
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import edu.csh.chase.kbetabrite.constants.KeyboardProtectionStatus
import edu.csh.chase.kbetabrite.constants.displayModeFromString
import edu.csh.chase.kbetabrite.models.*
import java.io.StringWriter
import java.util.*

class Test {

    val scanner = Scanner(System.`in`)

    var menu = true

    public fun main(args: Array<String>) {
        val packet = Packet(outFile = "/dev/ttyUSB0")

        while (true) {
            if (menu) printMenu()
            val i = scanner.nextLine()
            if (i.length() == 0) {
                continue
            }
            when (i[0]) {
                'c' -> packet.commands.clear()
                't' -> addText(packet)
                's' -> addString(packet)
                'e' -> packet.write()
                'r' -> printPacket(packet)
                'm' -> setMemory(packet)
                'o' -> menu = !menu
                'q' -> System.exit(0)
            }
        }
    }

    private fun printPacket(packet: Packet) {
        val buf = StringWriter()
        packet.write(buf)
        buf.toString().forEach {
            print("${java.lang.String.format("%02x", it.toInt())}:")
        }
        println()
    }

    private fun printMenu() {
        println("*******************")
        println("* Clear Packet: c *")
        println("* Text: t         *")
        println("* String: s       *")
        println("* Picture: p      *")
        println("* Mem Config: m   *")
        println("* Print: r        *")
        println("* Execute: e      *")
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

    private fun addString(packet: Packet) {
        println("String")
        val str = scanner.nextLine()
        println("File")
        val file = scanner.nextInt()
        packet.commands.add(WriteString(
                text = str,
                fileIndex = file
        ))
    }

    private fun setMemory(packet: Packet) {
        val mems = Array(packet.commands.size()) {
            when (packet.commands[it]) {
                is WriteText -> {
                    textMemConfig(packet.commands[it] as WriteText, KeyboardProtectionStatus.Locked)
                }
                is WriteString -> {
                    stringMemConfig(packet.commands[it] as WriteString, KeyboardProtectionStatus.Locked)
                }
                else -> {
                    dotPictureMemConfig(0, DotsPicture(ColorCode.EightColor, Array(0) { Array(0) { 0 } }), KeyboardProtectionStatus.Locked)
                }
            }
        }

        packet.commands.add(0, SetMemoryConfig(*mems))
    }

}
