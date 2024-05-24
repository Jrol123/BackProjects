package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "count_nodes")
    @Setter
    @Getter
    private Integer count_nodes;

    @Column(name = "username", unique = true, length = 50)
    @Setter
    @Getter
    private String username;
}
