import edu.csh.chase.kbetabrite.Packet
import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.models.DisplayPosition
import edu.csh.chase.kbetabrite.models.SignCodes
import edu.csh.chase.kbetabrite.models.WriteModes
import java.io.StringWriter

class Test {

    public fun main(args: Array<String>) {
        val p = Packet(outFile = "\\dev\\ttyUSB0",
                typeCode = SignCodes.AllSigns
        )
        p.commands.add(WriteText(
                text = "Hello World!",
                displayPosition = DisplayPosition.Fill,
                displayMode = WriteModes.Explode,
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
            print(java.lang.String.format("0x%02x", char.toInt()))
            first = true
        }
    }
}
