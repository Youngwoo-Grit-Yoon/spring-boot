package com.example.demo.data;

import com.example.demo.domain.Agent;
import com.example.demo.repository.AgentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final AgentRepository agentRepository;

    public DataLoader(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @PostConstruct
    private void loadData() {
        this.agentRepository.saveAll(List.of(
                new Agent("윤영우"),
                new Agent("주인선")
        ));
    }
}
