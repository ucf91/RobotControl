package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.domain.exception.ScriptException;

import java.util.List;

import static com.robotcontrol.demo.domain.Direction.*;

public abstract class Command implements ValueObject{
    protected static List<Direction> orientationRotateList = List.of(NORTH, EAST, SOUTH, WEST);

    abstract Position execute(Position position) throws ScriptException;
}
