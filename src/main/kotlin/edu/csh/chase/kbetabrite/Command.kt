package edu.csh.chase.kbetabrite

import edu.csh.chase.kbetabrite.models.CommandCodes

abstract class Command(val commandCode: CommandCodes) : Writable