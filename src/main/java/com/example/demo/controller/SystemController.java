package com.example.demo.controller;

import com.example.demo.domain.System;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {
    private final System system;

    public SystemController(System system) {
        this.system = system;
    }

    @GetMapping
    @RequestMapping("/type")
    String getType() {
        return this.system.getType();
    }

    @GetMapping
    @RequestMapping("/name")
    String getName() {
        return this.system.getName();
    }
}
