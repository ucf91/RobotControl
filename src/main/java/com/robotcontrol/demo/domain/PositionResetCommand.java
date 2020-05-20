package com.robotcontrol.demo.domain;

import lombok.Value;

@Value
public class PositionResetCommand extends Command{
    private int x;
    private int y;
    private Direction direction;

    public PositionResetCommand(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    Position execute(Position position) {
        return new Position(x,y,direction);
    }
}
