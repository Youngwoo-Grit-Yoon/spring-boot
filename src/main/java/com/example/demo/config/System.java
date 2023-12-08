package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Plain Old Java Object
 */
@ConfigurationProperties(prefix = "system")
public class System {
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
