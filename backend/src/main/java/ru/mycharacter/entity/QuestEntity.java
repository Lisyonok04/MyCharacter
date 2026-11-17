package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quests", schema = "mc")
@Getter
@Setter
public class QuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private DevelopmentBranchEntity branch;

    @Column(name = "parent_quest_id")
    private Long parentQuestId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Integer difficulty;

    @Column(name = "base_xp", nullable = false)
    private Integer baseXp;
}