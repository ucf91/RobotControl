package com.robotcontrol.demo.application.model;

import com.robotcontrol.demo.domain.Direction;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
public class ScriptLine {
    @NotNull(message = "order has to be provided")
    @Min(value = 0, message = "min value for order is 0")
    private int order;
    @NotNull(message = "commandName can't be null")
    private CommandName commandName;
    private int xPosition;
    private int yPosition;
    private Direction direction;
    private int steps;
}
