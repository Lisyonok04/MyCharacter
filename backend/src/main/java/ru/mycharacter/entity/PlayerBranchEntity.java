package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_branches", schema = "mc")
@Getter
@Setter
public class PlayerBranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_id", nullable = false)
    private Long playerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private DevelopmentBranchEntity branch;

    @Column(name = "branch_level", nullable = false)
    private Integer branchLevel;

    @Column(name = "branch_xp", nullable = false)
    private Integer branchXp;
}