package com.robotcontrol.demo;

import com.robotcontrol.demo.domain.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {
    protected static Script generateExampleScript() {
        return new Script(addExampleCommands());
    }

    protected static Script generateOffLimitScript() {
        List<Command> commands = addExampleCommands();
        commands.add(new ForwardCommand(6));
        return new Script(commands);
    }

    protected static Script generateExceedMaxStepsScript() {
        List<Command> commands = addExampleCommands();
        commands.add(new ForwardCommand(100));
        return new Script(commands);
    }

    protected static List<Command> addExampleCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new PositionResetCommand(1, 3, Direction.EAST));
        commands.add(new ForwardCommand(3));
        commands.add(new WaitCommand());
        commands.add(new TurnCommand(Turn.TURNAROUND));
        commands.add(new ForwardCommand(1));
        commands.add(new TurnCommand(Turn.RIGHT));
        commands.add(new ForwardCommand(2));
        return commands;
    }
}
