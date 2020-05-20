package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.domain.exception.ScriptException;

class Robot implements Entity{
    private Position position;

    public Robot() {
        this.position = new Position(0, 0, Direction.EAST);
    }

    public Robot(Position initialPosition) {
        this.position = initialPosition;
    }

    public Position runScript(Script script) throws ScriptException {
        this.position = script.start(position);
        return this.position;
    }


}
