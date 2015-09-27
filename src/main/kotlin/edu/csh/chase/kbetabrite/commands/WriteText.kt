package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.models.CommandCodes
import edu.csh.chase.kbetabrite.models.DisplayPosition
import edu.csh.chase.kbetabrite.models.WriteModes
import java.io.Writer

public class WriteText(val text: String,
                       val displayPosition: DisplayPosition,
                       val displayMode: WriteModes

) : Command(CommandCodes.WriteText) {
    override fun write(writer: Writer) {

    }
}