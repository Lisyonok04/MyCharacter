package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_stats", schema = "mc")
@Getter
@Setter
public class PlayerStatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_id", nullable = false)
    private Long playerId;

    @Column(name = "stat_code", nullable = false)
    private String statCode;

    @Column(name = "stat_name", nullable = false)
    private String statName;

    @Column(name = "current_value", nullable = false)
    private Integer currentValue;

    @Column(name = "current_xp", nullable = false)
    private Integer currentXp;
}