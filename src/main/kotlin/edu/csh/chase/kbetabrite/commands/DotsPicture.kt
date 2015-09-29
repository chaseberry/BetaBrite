package edu.csh.chase.kbetabrite.commands

import edu.csh.chase.kbetabrite.Writable
import edu.csh.chase.kbetabrite.carrigeReturn
import edu.csh.chase.kbetabrite.models.ColorCode
import edu.csh.chase.kbetabrite.sleepTime
import java.io.Writer
import java.util.*

data class DotsPicture(val width: Int,
                       val height: Int,
                       val colorCode: ColorCode,
                       val dots: ArrayList<ArrayList<Int>>) : Writable {

    override fun write(writer: Writer) {
        writer.write(height)//TODO make hex
        writer.write(width)//TODO make hex
        writer.flush()
        Thread.sleep(sleepTime)
        for (row in dots) {
            writer.write(row.joinToString(separator = "", truncated = ""))
            writer.write(carrigeReturn)
        }
    }

}