package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TurnCommandTest extends BaseTest {
    private TurnCommand turnCommand;

    @DisplayName("when position direction is EAST, then turnaround makes direction WEST")
    @Test
    public void testTurnCommand_turnaround() {
        //given
        Position position = new Position(1, 1, Direction.EAST);
        turnCommand = new TurnCommand(Turn.TURNAROUND);

        // when
        Position resultedPosition = this.turnCommand.execute(position);

        //then
        assertThat("returned position object should not be null", Objects.nonNull(resultedPosition), equalTo(true));
        assertThat("returned position direction should be west", resultedPosition, equalTo(new Position(1, 1, Direction.WEST)));

    }

    @DisplayName("when position direction is NORTH, then turn LEFT makes direction WEST")
    @Test
    public void testTurnCommand_turnLeft() {
        //given
        Position position = new Position(1, 1, Direction.NORTH);
        turnCommand = new TurnCommand(Turn.LEFT);

        // when
        Position resultedPosition = this.turnCommand.execute(position);

        //then
        assertThat("returned position object should not be null", Objects.nonNull(resultedPosition), equalTo(true));
        assertThat("returned position direction should be west", resultedPosition, equalTo(new Position(1, 1, Direction.WEST)));

    }

    @DisplayName("when position drection is WEST, then turnaround makes direction NORTH")
    @Test
    public void testTurnCommand_turnRight() {
        //given
        Position position = new Position(1, 1, Direction.WEST);
        turnCommand = new TurnCommand(Turn.RIGHT);

        // when
        Position resultedPosition = this.turnCommand.execute(position);

        //then
        assertThat("returned position object should not be null", Objects.nonNull(resultedPosition), equalTo(true));
        assertThat("returned position direction should be west", resultedPosition, equalTo(new Position(1, 1, Direction.NORTH)));

    }
}
