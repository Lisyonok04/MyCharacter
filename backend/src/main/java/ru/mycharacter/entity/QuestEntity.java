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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @Column(name = "base_xp", nullable = false)
    private Integer baseXp;
}