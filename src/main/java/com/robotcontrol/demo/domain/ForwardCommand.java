package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.domain.exception.ScriptException;
import lombok.Value;

import static com.robotcontrol.demo.domain.Direction.*;
import static com.robotcontrol.demo.domain.Environment.MAP_MAX_LENGTH;

@Value
public class ForwardCommand extends Command {
    private int steps;

    public ForwardCommand(int steps) {
        this.steps = steps;
    }

    @Override
    Position execute(Position position) throws ScriptException {
        Direction direction = position.getDirection();
        int newX = position.getX();
        int newY = position.getY();
        if (EAST == direction) {
            newX = newX + steps;
        }
        if (SOUTH == direction) {
            newY = newY + steps;
        }
        if (WEST == direction) {
            newX = newX - steps;
        }
        if (NORTH == direction) {
            newY = newY - steps;
        }
        if (newX > MAP_MAX_LENGTH || newX < 0 || newY > MAP_MAX_LENGTH || newY < 0) {
            throw new ScriptException("You reached the grid limits");
        }
        return new Position(newX, newY, position.getDirection());
    }
}
