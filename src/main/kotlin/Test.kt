import edu.csh.chase.kbetabrite.Packet
import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.models.DisplayPosition
import edu.csh.chase.kbetabrite.models.SignCodes
import edu.csh.chase.kbetabrite.models.WriteModes

fun main(args: Array<String>) {
    val p = Packet(outFile = "\\dev\\ttyUSB0",
            typeCode = SignCodes.AllSigns
    )
    p.commands.add(WriteText(
            text = "Hello World!",
            displayPosition = DisplayPosition.Fill,
            displayMode = WriteModes.Explode,
            fileIndex = 9
    ))
    p.write()
}