package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.models.SignCodes
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.*

data class Packet(
        val signCode: SignCodes = SignCodes.AllSigns,
        val outFile: String,
        val typeCode: SignCodes,
        val signAddress: String = "00",
        val commands: ArrayList<Command> = ArrayList<Command>()) : Writable {

    fun write() {
        write(OutputStreamWriter(FileOutputStream(java.io.File(outFile))))
    }

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
                writer.flush()
                Thread.sleep(sleepTime)
                command.write(writer)
                writer.write(endOfText)
            }

        }


        writer.write(endOfTransmission)
        writer.flush()
        writer.close()
    }


}