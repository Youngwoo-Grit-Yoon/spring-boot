package com.example.demo.controller;

import com.example.demo.domain.Agent;
import com.example.demo.repository.AgentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    Iterable<Agent> getAgents() {
        return this.agentRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Agent> getAgentById(@PathVariable String id) {
        return this.agentRepository.findById(id);
    }

    @PostMapping
    Agent postAgent(@RequestBody Agent agent) {
        return this.agentRepository.save(agent);
    }

    @PutMapping("/{id}")
    ResponseEntity<Agent> putAgent(@PathVariable String id,
                                   @RequestBody Agent agent) {
        return (!this.agentRepository.existsById(id)) ?
                new ResponseEntity<>(this.agentRepository.save(agent), HttpStatus.CREATED) :
                new ResponseEntity<>(this.agentRepository.save(agent), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteAgent(@PathVariable String id) {
        this.agentRepository.deleteById(id);
    }
}
