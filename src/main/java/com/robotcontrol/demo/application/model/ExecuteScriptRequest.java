package com.robotcontrol.demo.application.model;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value
public class ExecuteScriptRequest {
    @NotNull(message = "script lines can not be empty")
    @Valid
    private List<ScriptLine> scriptLines;
}
