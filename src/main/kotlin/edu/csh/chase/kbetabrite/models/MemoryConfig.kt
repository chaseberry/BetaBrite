package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.File
import edu.csh.chase.kbetabrite.Writable
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

fun stringMemConfig(fileIndex: Int, string: String, keyboardProtectionStatus: KeyboardProtectionStatus): MemoryConfig {
    return MemoryConfig(
            fileIndex = fileIndex,
            fileType = FileType.String,
            keyboardProtectionStatus = keyboardProtectionStatus,
            size = stringSizeToHex(string),
            qqqq = "0000"
    )
}

fun textMemConfig(fileIndex: Int, text: Text, keyboardProtectionStatus: KeyboardProtectionStatus): MemoryConfig {
    return MemoryConfig(
            fileIndex = fileIndex,
            fileType = FileType.Text,
            keyboardProtectionStatus = keyboardProtectionStatus,
            size = lang.String.format("%04x", 1 + text.text.length() + (2 * text.mode.name().length())),
            qqqq = text.startTime + text.endTime
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