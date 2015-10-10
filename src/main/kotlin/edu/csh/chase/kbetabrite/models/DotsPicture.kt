package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Writable
import edu.csh.chase.kbetabrite.carrigeReturn
import edu.csh.chase.kbetabrite.constants.ColorCode
import edu.csh.chase.kbetabrite.sleepTime
import java.io.Writer

data class DotsPicture(val colorCode: ColorCode,
                       val dots: Array<Array<Int>>) : Writable {

    val height: String
        get() {
            //Test sizing
            return java.lang.String.format("%02x", dots.size()).toUpperCase()
        }

    val width: String
        get() {
            //Test sizing
            return java.lang.String.format("%02x", dots[0].size()).toUpperCase()
        }

    override fun write(writer: Writer) {
        writer.write(height)
        writer.write(width)
        writer.flush()
        Thread.sleep(sleepTime)
        for (row in dots) {
            writer.write(row.joinToString(separator = "", truncated = ""))
            writer.write(carrigeReturn)
        }
    }

}