package edu.csh.chase.kbetabrite.constants

import edu.csh.chase.kbetabrite.Codable

fun displayModeFromString(mode: String): DisplayMode {

    return when (mode.toLowerCase()) {
        "rotate" -> DisplayMode.Rotate
        "hold" -> DisplayMode.Hold
        "flash" -> DisplayMode.Flash
        "rollup" -> DisplayMode.RollUp
        "rolldown" -> DisplayMode.RollDown
        "rollleft" -> DisplayMode.RollLeft
        "rollright" -> DisplayMode.RollRight
        "wipeup" -> DisplayMode.WipeUp
        "wipedown" -> DisplayMode.WipeDown
        "wipeleft" -> DisplayMode.WipeLeft
        "wiperight" -> DisplayMode.WipeRight
        "scroll" -> DisplayMode.Scroll
        "automode" -> DisplayMode.AutoMode
        "rollin" -> DisplayMode.RollIn
        "rollout" -> DisplayMode.RollOut
        "wipein" -> DisplayMode.WipeIn
        "wipeout" -> DisplayMode.WipeOut
        "compressedrotate" -> DisplayMode.CompressedRotate
        "explode" -> DisplayMode.Explode
        "clock" -> DisplayMode.Clock
        "twinkle" -> DisplayMode.Twinkle
        "sparkle" -> DisplayMode.Sparkle
        "snow" -> DisplayMode.Snow
        "interlock" -> DisplayMode.Interlock
        "switch" -> DisplayMode.Switch
        "slide" -> DisplayMode.Slide
        "spray" -> DisplayMode.Spray
        "starburst" -> DisplayMode.StarBurst
        "welcome" -> DisplayMode.Welcome
        "slotmachine" -> DisplayMode.SlotMachine
        "newflash" -> DisplayMode.NewFlash
        "trumpet" -> DisplayMode.Trumpet
        "cyclecolors" -> DisplayMode.CycleColors
        "thankyou" -> DisplayMode.ThankYou
        "nosmoking" -> DisplayMode.NoSmoking
        "dontdrinkanddrive" -> DisplayMode.DontDrinkAndDrive
        "fish" -> DisplayMode.Fish
        "fireworks" -> DisplayMode.FireWorks
        "balloon" -> DisplayMode.Balloon
        "cherrybomb" -> DisplayMode.CherryBomb
        else -> DisplayMode.Rotate
    }
}

public enum class DisplayMode(override val code: String) : Codable {
    Rotate("a"),
    Hold("b"),
    Flash("c"),
    RollUp("e"),
    RollDown("f"),
    RollLeft("g"),
    RollRight("h"),
    WipeUp("i"),
    WipeDown("j"),
    WipeLeft("k"),
    WipeRight("l"),
    Scroll("m"),
    AutoMode("o"),
    RollIn("p"),
    RollOut("q"),
    WipeIn("r"),
    WipeOut("s"),
    CompressedRotate("t"),
    Explode("u"),
    Clock("v"),
    Twinkle("n0"),
    Sparkle("n1"),
    Snow("n2"),
    Interlock("n3"),
    Switch("n4"),
    Slide("n5"),
    Spray("n6"),
    StarBurst("n7"),
    Welcome("n8"),
    SlotMachine("n9"),
    NewFlash("nA"),
    Trumpet("nB"),
    CycleColors("nC"),
    ThankYou("nS"),
    NoSmoking("nU"),
    DontDrinkAndDrive("nV"),
    Fish("nW"),
    FireWorks("nX"),
    Balloon("nY"),
    CherryBomb("nZ")
}