package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "quest_stats", schema = "mc")
@Getter
@Setter
public class QuestStatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quest_id", nullable = false)
    private Long questId;

    @Column(name = "stat_code", nullable = false, length = 32)
    private String statCode;

    @Column(name = "stat_name", nullable = false, length = 64)
    private String statName;

    @Column(name = "stat_points_reward", nullable = false)
    private Integer statPointsReward;

    @Column(name = "xp_multiplier", nullable = false, precision = 3, scale = 2)
    private BigDecimal xpMultiplier;
}