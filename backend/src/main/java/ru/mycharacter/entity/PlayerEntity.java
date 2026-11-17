package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "players", schema = "mc")
@Getter
@Setter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "character_name", nullable = false)
    private String characterName;

    @Column(nullable = false)
    private Integer level;

    @Column(name = "total_xp", nullable = false)
    private Integer totalXp;

    @Column(name = "current_streak", nullable = false)
    private Integer currentStreak;
}