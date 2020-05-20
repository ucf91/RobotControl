package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.domain.exception.ScriptException;

public class Environment implements RootEntity{
    public static final int MAP_MAX_LENGTH = 5;
    private Robot robot;

    public Environment(){
        robot = new Robot();
    }

    public Position startRobot(Script script) throws ScriptException {
        return this.robot.runScript(script);
    }
}
