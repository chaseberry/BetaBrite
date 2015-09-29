package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.constants.CommandCode
import edu.csh.chase.kbetabrite.constants.SpecialFunction
import java.io.Writer

class SetMemoryConfig(): Command(CommandCode.WriteSpecialFunction){

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(SpecialFunction.SetMemoryConfig.code)

    }

}