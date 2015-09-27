package edu.csh.chase.kbetabrite

val nullChar = 0x00.toString()
val startOfHeader = 0x01.toString()
val startOfText = 0x02.toString()
val endOfText = 0x03.toString()
val endOfTransmission = 0x04.toString()
val escape = 0x1B.toString()
val sleepTime = 100L

val startOfPacket = nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar + nullChar