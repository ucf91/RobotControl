package com.robotcontrol.demo.application.factory;

import com.robotcontrol.demo.application.exception.BadRequestException;
import com.robotcontrol.demo.application.model.ScriptLine;
import com.robotcontrol.demo.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.robotcontrol.demo.domain.Turn.*;

// factory design pattern with lambda expression
public class ScriptCommandFactory {
    private ScriptCommandFactory() {
    }

    private static final Map<String, Function<ScriptLine, Command>> commandFactoryMap = new HashMap<>();

    static {
        commandFactoryMap.put("POSITION", scriptLine -> new PositionResetCommand(scriptLine.getXPosition(), scriptLine.getYPosition(),
                scriptLine.getDirection()));

        commandFactoryMap.put("FORWARD", scriptLine -> new ForwardCommand(scriptLine.getSteps()));

        commandFactoryMap.put("WAIT", scriptLine -> new WaitCommand());

        commandFactoryMap.put("TURNAROUND", scriptLine -> new TurnCommand(TURNAROUND));

        commandFactoryMap.put("RIGHT", scriptLine -> new TurnCommand(RIGHT));

        commandFactoryMap.put("LEFT", scriptLine -> new TurnCommand(LEFT));

    }


    public static Command getCommand(ScriptLine scriptLine) {
        Function<ScriptLine, Command> mappingFunction = commandFactoryMap.get(scriptLine.getCommandName().toString());
        if (Objects.isNull(mappingFunction)) {
            throw new BadRequestException("command can't be executed");
        }
        try {
            return mappingFunction.apply(scriptLine);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }
}
