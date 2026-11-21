package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "quest_completions", schema = "mc")
@Getter
@Setter
public class QuestCompletionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_id", nullable = false)
    private Long playerId;

    @Column(name = "quest_id", nullable = false)
    private Long questId;

    @Column(name = "completion_date", nullable = false)
    private LocalDate completionDate;

    @Column(name = "xp_awarded", nullable = false)
    private Integer xpAwarded;
}
