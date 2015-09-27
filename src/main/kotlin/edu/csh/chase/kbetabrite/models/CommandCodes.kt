package edu.csh.chase.kbetabrite.models

public enum class CommandCodes(val code: Char) {
    WriteText('A'),
    ReadText('B'),
    WriteSpecialFunction('E'),
    ReadSpecialFunction('F'),
    WriteString('G'),
    ReadString('H'),
    WriteSmallDots('I'),
    ReadSmallDots('J'),
    WriteRGBDots('K'),
    ReadRGBDots('L'),
    WriteLargeDots('M'),
    ReadLargeDots('N'),
    WriteAlphaisionBulletin('O'),
    SetTimeout('T')
}