package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.models.CommandCodes
import edu.csh.chase.kbetabrite.models.DisplayPosition
import edu.csh.chase.kbetabrite.models.WriteModes
import java.io.Writer

public class WriteText(val text: String,
                       val fileIndex: Int,
                       val displayPosition: DisplayPosition,
                       val displayMode: WriteModes

) : Command(CommandCodes.WriteText) {

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(File[fileIndex])
        writer.write(0x1B.toString())
        writer.write(displayPosition.code)
        writer.write(displayMode.code)
        writer.write(text)
    }
    
}