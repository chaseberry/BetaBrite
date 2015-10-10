package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.*
import edu.csh.chase.kbetabrite.constants.DisplayMode
import edu.csh.chase.kbetabrite.constants.DisplayPosition
import java.io.Writer
import kotlin.text.Regex

class Text(text: String, val mode: DisplayMode, val displayPosition: DisplayPosition) : Writable {

    val text: String

    init {
        this.text = parseIncludes(text)
    }

    override fun write(writer: Writer) {
        writer.write(escape)
        writer.write(displayPosition.code)
        writer.write(mode.code)
        writer.write(text)
    }

    public fun parseIncludes(text: String): String {
        return parseStringInclude(parsePictureInclude(text))
    }

    public fun parseStringInclude(text: String): String {
        var newText = text
        val stringPattern = Regex("<s:(?<id>\\d+)>")
        val stringMatch = stringPattern.matchAll(text)
        stringMatch.forEach {
            newText = newText.replace(it.groups[0]!!.value, stringInclude + File[it.groups[1]!!.value.toInt()])
        }
        return newText
    }

    private fun parsePictureInclude(text: String): String {
        var newText = text
        val stringPattern = Regex("<p:(?<id>\\d+)>")
        val stringMatch = stringPattern.matchAll(text)
        stringMatch.forEach {
            newText = newText.replace(it.groups[0]!!.value, pictureInclude + File[it.groups[1]!!.value.toInt()])
        }
        return newText
    }

}