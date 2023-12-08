package com.example.demo.controller;

import com.example.demo.config.CallInfraSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call-infra-system")
public class CallInfraSystemController {
    private final CallInfraSystem callInfraSystem;

    public CallInfraSystemController(CallInfraSystem callInfraSystem) {
        this.callInfraSystem = callInfraSystem;
    }

    @GetMapping
    CallInfraSystem getCallInfraSystem() {
        return this.callInfraSystem;
    }
}
