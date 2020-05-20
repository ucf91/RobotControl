package com.robotcontrol.demo.application.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.robotcontrol.demo.application.exception.BadRequestException;
import com.robotcontrol.demo.application.model.ExecuteScriptRequest;
import com.robotcontrol.demo.application.service.ScriptService;
import com.robotcontrol.demo.domain.Position;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Validated
public class ScriptsController {

    private final ScriptService scriptService;

    @PostMapping("/scripts")
    public Position executeScript(@RequestBody @Valid ExecuteScriptRequest executeScriptRequest) {
        return scriptService.executeScript(executeScriptRequest);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestException> handleException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new BadRequestException(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<BadRequestException> handleFormatException(InvalidFormatException ex) {
        return new ResponseEntity<>(new BadRequestException(ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
