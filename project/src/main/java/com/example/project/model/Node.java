package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    @EmbeddedId
    private NodeId id;

    @Column(name = "text")
    private String text;

    @Column(name = "name", nullable = false)
    private String name;

    public Node setText(String text) {
        this.text = text;
        return this;
    }

    public NodeId setId(User user) {
        id = new NodeId(user, user.getCount_nodes());
        user.incrementCount();
        return null;
    }

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

}

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
class NodeId implements Serializable {

    // TODO: Не работает каскадное удаление
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "user_id", nullable = false)
//    private Integer userId;

}