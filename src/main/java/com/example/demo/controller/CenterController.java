package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Value("${center-name: Busan}")
    private String name; // 애플리케이션 환경에 center-name의 속성값이 정의되지 않은 경우에는 Busan이 저장됩니다.

    @Value("${center-infra: ${center-name} center is On-Premise}")
    private String infra;

    @GetMapping
    @RequestMapping("/name")
    String getName() {
        return name;
    }


    @GetMapping
    @RequestMapping("/infra")
    String getInfra() {
        return infra;
    }
}
