package com.example.project.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "count_nodes")
    private Integer count_nodes;

    @Column(name = "username", unique = true, length = 50)
    private String username;

    public Integer getCount_nodes() {
        return count_nodes;
    }

    public void setCount_nodes(Integer count_nodes) {
        this.count_nodes = count_nodes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
