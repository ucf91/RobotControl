package com.robotcontrol.demo.domain;

import com.robotcontrol.demo.BaseTest;
import com.robotcontrol.demo.domain.exception.ScriptException;
import com.robotcontrol.demo.domain.service.EnvironmentDomainService;
import com.robotcontrol.demo.domain.service.EnvironmentDomainServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EnvironmentDomainServiceTest extends BaseTest {

    private EnvironmentDomainService environmentDomainService;

    public EnvironmentDomainServiceTest() {
        environmentDomainService = new EnvironmentDomainServiceImpl();
    }

    @DisplayName("when run a valid script then a correct robot position should be returned")
    @Test
    public void testMoveRobot_successfulExceution() throws ScriptException {
        //given a valid example of script
        Script script = generateExampleScript();

        //when
        Position position = environmentDomainService.moveRobot(script);

        //then
        assertThat("returned position object should not be null", Objects.nonNull(position), equalTo(true));
        assertThat("returned position should be in 3,1,NORTH", position, equalTo(new Position(3, 1, Direction.NORTH)));
    }

    @DisplayName("when run a script with steps more then 25 then Script exception should be thrown")
    @Test
    public void testMoveRobot_GridMaxStepsError() {
        // given a valid example of script
        Script script = generateExceedMaxStepsScript();

        //when /then
        assertThrows(ScriptException.class, () -> environmentDomainService.moveRobot(script));
    }

    @DisplayName("when run a script with steps beyond the grid boundaries then Script exception should be thrown")
    @Test
    public void testMoveRobot_GridLimitError() {
        // given a valid example of script
        Script script = generateOffLimitScript();

        //when /then
        assertThrows(ScriptException.class, () -> environmentDomainService.moveRobot(script));
    }
}
