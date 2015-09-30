package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.Writable
import edu.csh.chase.kbetabrite.commands.WriteString
import edu.csh.chase.kbetabrite.commands.WriteText
import edu.csh.chase.kbetabrite.constants.FileType
import edu.csh.chase.kbetabrite.constants.KeyboardProtectionStatus
import java.io.Writer
import java.lang

data class MemoryConfig(val fileIndex: Int,
                        val fileType: FileType,
                        val keyboardProtectionStatus: KeyboardProtectionStatus,
                        val size: String,
                        val qqqq: String) : Writable {

    override fun write(writer: Writer) {
        writer.write(File[fileIndex])
        writer.write(fileType.code)
        writer.write(keyboardProtectionStatus.code)
        writer.write(size)
        writer.write(qqqq)
    }
}

fun stringSizeToHex(string: String): String {
    if (string.length() >= 125) {
        //TODO Don't throw an exception
        throw RuntimeException("$string is longer than 125 chars")
    }
    return lang.String.format("%04x", string.length())
}

fun stringMemConfig(writeString: WriteString, keyboardProtectionStatus: KeyboardProtectionStatus): MemoryConfig {
    return MemoryConfig(
            fileIndex = writeString.fileIndex,
            fileType = FileType.String,
            keyboardProtectionStatus = keyboardProtectionStatus,
            size = stringSizeToHex(writeString.text),
            qqqq = "0000"
    )
}

fun textMemConfig(writeText: WriteText, keyboardProtectionStatus: KeyboardProtectionStatus): MemoryConfig {
    val text = writeText.texts
    return MemoryConfig(
            fileIndex = writeText.fileIndex,
            fileType = FileType.Text,
            keyboardProtectionStatus = keyboardProtectionStatus,
            size = lang.String.format("%04x", 1 + text.sumBy { it.text.length() } + (text.sumBy { it.mode.name().length() })),
            qqqq = writeText.startTime + writeText.endTime
    )
}

fun dotPictureMemConfig(fileIndex: Int, dotsPicture: DotsPicture, keyboardProtectionStatus: KeyboardProtectionStatus): MemoryConfig {
    return MemoryConfig(
            fileIndex = fileIndex,
            fileType = FileType.DotsImage,
            keyboardProtectionStatus = keyboardProtectionStatus,
            size = lang.String.format("%02x", dotsPicture.height) + lang.String.format("%02x", dotsPicture.width),
            qqqq = dotsPicture.colorCode.code
    )
}