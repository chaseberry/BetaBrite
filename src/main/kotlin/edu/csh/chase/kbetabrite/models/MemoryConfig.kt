package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Writable
import edu.csh.chase.kbetabrite.constants.FileType
import edu.csh.chase.kbetabrite.constants.KeyboardProtectionStatus
import edu.csh.chase.kbetabrite.models.DotsPicture
import java.io.Writer
import java.lang

data class MemoryConfig(val fileIndex: Int,
                        val fileType: FileType,
                        val keyboardProtectionStatus: KeyboardProtectionStatus,
                        val size: String,
                        val qqqq: String) : Writable {

    override fun write(writer: Writer) {

    }
}

fun stringSizeToHex(string: String): String {
    if (string.length() >= 125) {
        println("$string is greater than 125. Truncating")
    }
    var hex = Integer.toHexString(string.length())
    while (hex.length() < 4) {
        hex = "0" + hex
    }
    return hex
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
            size = stringSizeToHex(text.text),
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