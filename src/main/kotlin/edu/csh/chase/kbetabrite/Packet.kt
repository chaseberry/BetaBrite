package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.constants.SignCode
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.*

data class Packet(
        val signCode: SignCode = SignCode.AllSigns,
        val outFile: String,
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
        writer.write(signCode.code)
        writer.write(signAddress)

        if (commands.size() == 1) {
            writer.write(startOfText)
            commands[0].write(writer)
        } else {
            for (command in commands) {
                writer.write(startOfText)
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