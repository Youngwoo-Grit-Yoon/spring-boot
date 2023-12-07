package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agent {
    @Id
    private String id;
    private String name;

    /**
     * JPA를 사용해 DB에 데이터를 생성할 때는 기본 생성자가 필요하다.
     */
    public Agent(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
