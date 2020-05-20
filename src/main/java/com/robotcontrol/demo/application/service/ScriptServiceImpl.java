package com.robotcontrol.demo.application.service;

import com.robotcontrol.demo.application.exception.BadRequestException;
import com.robotcontrol.demo.application.factory.ScriptCommandFactory;
import com.robotcontrol.demo.application.model.ExecuteScriptRequest;
import com.robotcontrol.demo.application.model.ScriptLine;
import com.robotcontrol.demo.domain.Position;
import com.robotcontrol.demo.domain.Script;
import com.robotcontrol.demo.domain.exception.ScriptException;
import com.robotcontrol.demo.domain.service.EnvironmentDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScriptServiceImpl implements ScriptService {
    private final EnvironmentDomainService environmentDomainService;

    // mapping logic should be decoupled from the domain logic and would be smelly if it's done in the controller
    // since it's not a simple mapping that's why I introduced this application service
    @Override
    public Position executeScript(ExecuteScriptRequest executeScriptRequest) {
        Script script = executeScriptRequest.getScriptLines()
                .stream()
                .sorted(Comparator.comparing(ScriptLine::getOrder))
                .map(ScriptCommandFactory::getCommand)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Script::new));
        try {
            return environmentDomainService.moveRobot(script);
        } catch (ScriptException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
