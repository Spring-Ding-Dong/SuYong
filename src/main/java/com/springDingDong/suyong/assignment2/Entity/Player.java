package com.springDingDong.suyong.assignment2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Foot foot;

    private int height;
    private int weight;
    private int backNumber;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
