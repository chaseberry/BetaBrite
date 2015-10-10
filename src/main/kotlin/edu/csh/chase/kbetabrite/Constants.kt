package edu.csh.chase.kbetabrite

val nullChar = 0x00.toChar().toString()
val startOfHeader = 0x01.toChar().toString()
val startOfText = 0x02.toChar().toString()
val endOfText = 0x03.toChar().toString()
val endOfTransmission = 0x04.toChar().toString()
val stringInclude = 0x10.toChar().toString()
val pictureInclude = 0x14.toChar().toString()
val escape = 0x1B.toChar().toString()
val carrigeReturn = 0x0D.toChar().toString()
val sleepTime = 145L

val startOfPacket = nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar