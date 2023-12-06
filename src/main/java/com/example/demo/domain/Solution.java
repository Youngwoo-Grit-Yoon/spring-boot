package com.example.demo.domain;

import java.util.UUID;

public class Solution {
    private final String id;
    private String name;

    public Solution(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Solution(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
