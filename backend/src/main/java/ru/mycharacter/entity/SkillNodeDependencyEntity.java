package ru.mycharacter.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill_node_dependencies", schema = "mc")
@Getter
@Setter
public class SkillNodeDependencyEntity {

    @EmbeddedId
    private SkillNodeDependencyId id;
}
