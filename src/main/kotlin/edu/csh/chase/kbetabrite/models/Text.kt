package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Writable
import edu.csh.chase.kbetabrite.constants.DisplayMode
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import edu.csh.chase.kbetabrite.escape
import java.io.Writer

data class Text(val text: String,
                val mode: DisplayMode,
                val displayPosition: DisplayPosition) : Writable {

    override fun write(writer: Writer) {
        writer.write(escape)
        writer.write(displayPosition.code)
        writer.write(mode.code)
        writer.write(text)
    }


}