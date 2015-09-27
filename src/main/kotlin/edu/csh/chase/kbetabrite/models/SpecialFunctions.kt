package edu.csh.chase.kbetabrite.models

//TODO change to String and support multiple char functions
public enum class SpecialFunctions(code: Char) {
    SetTimeOfDay(' '),
    ChangeSpeaker('!'),
    SetMemoryConfig('$'),
    SetDayOfWeek('&'),
    SetTimeFormat('\''),
    GenerateSpeakerTone('('),
    SetRunTableTime(')'),
    DisplayTextAtPosition('+'),
    SoftReset(','),
    SetRunSequence('.'),
    SetDimmingRegister('/'),
    SetRunDayTable('2'),
    ClearError('4'),
    SetCounter('5'),
    SetSerialAddress('7'),
    SetLargeDotMemoryConfig('8'),
    AppendLargeDotMemoryConfig('9'),
    SetRunFileTimes(':'),
    SetDate(';'),
    ProgramCustomCharacterSet('<'),
    SetAutomodeTable('>'),
    SetDimmingControlRegister('@'),
    SetColorCorrection('C'),
    SetTemperatureOffset('T'),
}