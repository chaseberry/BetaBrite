package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.constants.CommandCode
import java.io.Writer

class WriteString(val fileIndex: Int,
                  val text: String) : Command(CommandCode.WriteString) {

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(File[fileIndex])
        if (text.length() > 120) {
            writer.write(text.substring(0, 120))
        } else {
            writer.write(text)
        }
    }

}