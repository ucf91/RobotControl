package com.robotcontrol.demo.domain.service;

import com.robotcontrol.demo.domain.Position;
import com.robotcontrol.demo.domain.Script;
import com.robotcontrol.demo.domain.exception.ScriptException;

public interface EnvironmentDomainService {
    Position moveRobot(Script script) throws ScriptException;
}
