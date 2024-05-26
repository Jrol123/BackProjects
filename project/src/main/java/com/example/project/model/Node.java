package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Node {
    @EmbeddedId
    private NodeId id;

    @Column(name = "text")
    private String text;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

}

@Getter
@Embeddable
class NodeId implements Serializable {

    // TODO: Не работает каскадное удаление
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "user_id", nullable = false)
//    private Integer userId;

}