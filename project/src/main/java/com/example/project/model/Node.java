package com.example.project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Node {
    @EmbeddedId
    private NodeId id;

    public NodeId getId() {
        return id;
    }

    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

@Embeddable
class NodeId implements Serializable {
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}