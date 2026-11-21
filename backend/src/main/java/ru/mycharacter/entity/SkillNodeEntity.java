package ru.mycharacter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill_nodes", schema = "mc")
@Getter
@Setter
public class SkillNodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private DevelopmentBranchEntity branch;

    @Column(name = "code", nullable = false, unique = true, length = 64)
    private String code;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "required_branch_level", nullable = false)
    private Integer requiredBranchLevel;

    @Column(name = "required_player_level", nullable = false)
    private Integer requiredPlayerLevel;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;
}
