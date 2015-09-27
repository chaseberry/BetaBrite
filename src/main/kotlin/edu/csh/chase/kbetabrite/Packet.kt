package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.models.SignCodes
import java.io.Writer
import java.util.*

data class Packet(
        val signCode: SignCodes = SignCodes.AllSigns,
        val outFile: String,
        val typeCode: SignCodes,
        val signAddress: String = "00",
        val commands: ArrayList<Command>) : Writable {

    override fun write(writer: Writer) {
        if (commands.size() == 0) {
            return
        }
        writer.write(startOfPacket)
        writer.write(startOfHeader)
        writer.write(typeCode.code)
        writer.write(signAddress)
        writer.write(startOfText)

        if (commands.size() == 1) {
            commands[0].write(writer)
        } else {
            for (command in commands) {
                Thread.sleep(100)
                command.write(writer)
                writer.write(endOfText)
            }

        }


        writer.write(endOfTransmission)
    }


}