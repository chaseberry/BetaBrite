package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Command
import edu.csh.chase.kbetabrite.constants.CommandCode
import edu.csh.chase.kbetabrite.constants.SpecialFunction
import edu.csh.chase.kbetabrite.models.MemoryConfig
import java.io.Writer

class SetMemoryConfig(vararg val memConfigs: MemoryConfig) : Command(CommandCode.WriteSpecialFunction) {

    override fun write(writer: Writer) {
        writer.write(commandCode.code)
        writer.write(SpecialFunction.SetMemoryConfig.code)
        memConfigs.forEach {
            it.write(writer)
        }
    }

}