package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.constants.DisplayMode
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import edu.csh.chase.kbetabrite.constants.SignCode
import edu.csh.chase.kbetabrite.models.Text
import java.io.StringWriter
import java.lang

class Test {

    public fun main(args: Array<String>) {
        val p = Packet(outFile = "/dev/ttyUSB0",
                typeCode = SignCode.AllSigns
        )
        p.commands.add(WriteText(
                texts = *arrayOf(Text("Hello World", DisplayMode.StarBurst, DisplayPosition.Fill)),
                fileIndex = 9
        ))
        val writer = StringWriter()
        p.write(writer)
        p.write()
        var first = false
        writer.toString().forEach { char ->
            if (first) {
                print(":")
            }
            print(lang.String.format("0x%02x", char.toInt()))
            first = true
        }
        println()
    }
}
