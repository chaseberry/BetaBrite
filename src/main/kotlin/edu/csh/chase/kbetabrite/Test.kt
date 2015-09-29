package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.commands.SetMemoryConfig
import edu.csh.chase.kbetabrite.constants.DisplayMode
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import edu.csh.chase.kbetabrite.constants.KeyboardProtectionStatus
import edu.csh.chase.kbetabrite.constants.SignCode
import edu.csh.chase.kbetabrite.models.Text
import edu.csh.chase.kbetabrite.models.stringMemConfig
import edu.csh.chase.kbetabrite.models.textMemConfig
import java.io.StringWriter
import java.lang

class Test {

    public fun main(args: Array<String>) {
        val p = Packet(outFile = "/dev/ttyUSB0",
                typeCode = SignCode.AllSigns
        )
        p.commands.add(SetMemoryConfig(
                stringMemConfig(8, "Hello", KeyboardProtectionStatus.Locked),
                textMemConfig(9, Text(
                        text = "Hello",
                        displayPosition = DisplayPosition.Fill,
                        mode = DisplayMode.Clock
                ), KeyboardProtectionStatus.Locked)
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
