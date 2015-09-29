package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.commands.WriteSmallDots
import edu.csh.chase.kbetabrite.constants.ColorCode
import edu.csh.chase.kbetabrite.constants.SignCode
import edu.csh.chase.kbetabrite.models.DotsPicture
import java.io.StringWriter
import java.lang

class Test {

    public fun main(args: Array<String>) {
        val p = Packet(outFile = "/dev/ttyUSB0",
                typeCode = SignCode.AllSigns
        )
        p.commands.add(WriteSmallDots(
                dotsPicture = DotsPicture(ColorCode.EightColor, Array(12) { Array(12) { 0 } }),
                fileIndex = 9
        ))
        val writer = StringWriter()
        p.write(writer)
        //p.write()
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
