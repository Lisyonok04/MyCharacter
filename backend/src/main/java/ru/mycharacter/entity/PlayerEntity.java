package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "players", schema = "mc")
@Getter
@Setter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true, length = 64)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true, length = 128)
    private String email;

    @Column(name = "character_name", nullable = false, length = 64)
    private String characterName;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "total_xp", nullable = false)
    private Integer totalXp;

    @Column(name = "current_streak", nullable = false)
    private Integer currentStreak;

    @Column(name = "last_active_date")
    private LocalDate lastActiveDate;
}