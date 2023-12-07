package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Agent {
    @Id
    private String id;
    private String name;

    /**
     * JPA를 사용해 DB에 데이터를 생성할 때는 기본 생성자(no-argument)가 필요하다.
     */
    public Agent() {

    }

    public Agent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Agent(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public void setId(String id) {
        this.id = id;
    }
}
