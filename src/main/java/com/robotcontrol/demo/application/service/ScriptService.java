package com.robotcontrol.demo.application.service;

import com.robotcontrol.demo.application.model.ExecuteScriptRequest;
import com.robotcontrol.demo.domain.Position;

public interface ScriptService {
    Position executeScript(ExecuteScriptRequest executeScriptRequest);
}
