package edu.csh.chase.kbetabrite.models

import edu.csh.chase.kbetabrite.Codable

public enum class WriteModes(override val code: String) : Codable {
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
    CycleColors("nC")
}