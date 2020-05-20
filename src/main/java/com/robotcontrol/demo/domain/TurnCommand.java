package com.robotcontrol.demo.domain;

import lombok.Value;

@Value
public class TurnCommand extends Command {
    private final Turn turn;

    public TurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    Position execute(Position position) {
        int positionDirectionIndex = orientationRotateList.indexOf(position.getDirection());
        Direction direction = null;
        if (Turn.RIGHT == turn) {
            direction = orientationRotateList.get((positionDirectionIndex + 1) % orientationRotateList.size());
        }

        if (Turn.LEFT == turn) {
            direction = orientationRotateList.get((positionDirectionIndex + 3) % orientationRotateList.size());
        }

        if (Turn.TURNAROUND == turn) {
            direction = orientationRotateList.get((positionDirectionIndex + 2) % orientationRotateList.size());
        }
        return new Position(position.getX(), position.getY(), direction);
    }
}
