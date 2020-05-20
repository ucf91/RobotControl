package com.robotcontrol.demo.domain.service;

import com.robotcontrol.demo.domain.Environment;
import com.robotcontrol.demo.domain.Position;
import com.robotcontrol.demo.domain.Script;
import com.robotcontrol.demo.domain.exception.ScriptException;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentDomainServiceImpl implements EnvironmentDomainService {

    @Override
    public Position moveRobot(Script script) throws ScriptException {
        Environment environment = new Environment();
        return environment.startRobot(script);
    }
}
