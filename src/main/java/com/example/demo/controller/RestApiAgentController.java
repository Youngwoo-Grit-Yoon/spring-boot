package com.example.demo.controller;

import com.example.demo.domain.Agent;
import com.example.demo.repository.AgentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class RestApiAgentController {
    private final AgentRepository agentRepository;

    public RestApiAgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;

        this.agentRepository.saveAll(List.of(
                new Agent("홍길동"),
                new Agent("강감찬"),
                new Agent("이순신")
        ));
    }
}
