package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.BaseTest;
import com.robotcontrol.demo.domain.exception.ScriptException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ScriptTest extends BaseTest {

    @DisplayName("when run a valid script then a correct robot position should be returned")
    @Test
    public void testScriptExecution_successfulRun() throws ScriptException {
        //given example commands
        Script script = new Script(addExampleCommands());

        // when
        Position resultedPosition = script.start(new Position(0,0,Direction.EAST));

        //then
        assertThat("returned position object should not be null", Objects.nonNull(resultedPosition), equalTo(true));
        assertThat("returned position should be in 3,1,NORTH", resultedPosition, equalTo(new Position(3, 1, Direction.NORTH)));

    }
}
