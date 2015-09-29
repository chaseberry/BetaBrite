package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.constants.CommandCode
import edu.csh.chase.kbetabrite.models.DotsPicture
import java.io.Writer

class WriteSmallDots(val fileIndex: Int,
                     val dotsPicture: DotsPicture) : Command(CommandCode.WriteSmallDots) {

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(File[fileIndex])
        dotsPicture.write(writer)
    }

}