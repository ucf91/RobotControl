package com.robotcontrol.demo.domain;

import lombok.Value;

@Value
public class WaitCommand extends Command {
    @Override
    Position execute(Position position) {
        return position;
    }
}
