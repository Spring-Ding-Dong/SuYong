package com.springDingDong.suyong.assignment2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String manager;

    @OneToMany(mappedBy = "team")
    List<Player> players = new ArrayList<Player>();
}
