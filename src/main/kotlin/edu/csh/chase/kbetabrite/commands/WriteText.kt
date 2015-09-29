package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.constants.CommandCode
import edu.csh.chase.kbetabrite.models.Text
import java.io.Writer

public class WriteText(val fileIndex: Int,
                       vararg val texts: Text) : Command(CommandCode.WriteText) {

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(File[fileIndex])
        texts.forEach {
            it.write(writer)
        }
    }

}