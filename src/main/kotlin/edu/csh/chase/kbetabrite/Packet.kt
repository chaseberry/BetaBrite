package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.models.SignCodes
import java.io.Writer

data class Packet(
        val signCode: SignCodes = SignCodes.AllSigns,
        val outFile: String,
        val typeCode: SignCodes,
        val signAddress: String = "00") : Writable {

    override fun write(writer: Writer) {

    }


}