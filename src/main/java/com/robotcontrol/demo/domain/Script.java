package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.domain.exception.ScriptException;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

import static com.robotcontrol.demo.domain.Environment.MAP_MAX_LENGTH;

@Value
public class Script implements ValueObject {
    private static final int MAX_STEPS = MAP_MAX_LENGTH * MAP_MAX_LENGTH;

    private List<Command> commandList;

    public Script(List<Command> commands) {
        this.commandList = commands;
    }

    public Position start(Position position) throws ScriptException {
        validateMaxStepsLimit();
        Position resultPosition = position;
        for (Command command : commandList) {
            resultPosition = command.execute(resultPosition);
        }
        return resultPosition;
    }

    private void validateMaxStepsLimit() throws ScriptException {
        int totalSteps = commandList.stream()
                .filter(command -> command instanceof ForwardCommand)
                .map(command -> (ForwardCommand) command)
                .collect(Collectors.summingInt(ForwardCommand::getSteps));
        if (totalSteps > MAX_STEPS) {
            throw new ScriptException("you reached max steps");
        }
    }
}
