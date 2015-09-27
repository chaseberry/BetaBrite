package edu.csh.chase.kbetabrite

val nullChar = 0x00.toChar().toString()
val startOfHeader = 0x01.toChar().toString()
val startOfText = 0x02.toChar().toString()
val endOfText = 0x03.toChar().toString()
val endOfTransmission = 0x04.toChar().toString()
val escape = 0x1B.toChar().toString()
val sleepTime = 100L

val startOfPacket = nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar