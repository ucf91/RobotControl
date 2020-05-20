package com.robotcontrol.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Position implements ValueObject{
    private int x;
    private int y;
    private Direction direction;
}
