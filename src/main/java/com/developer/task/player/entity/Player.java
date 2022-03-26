package com.developer.task.player.entity;

import com.developer.task.player.enums.PlayerPosition;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION")
    private PlayerPosition position;

}
