package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.SkillNodeDependencyEntity;
import ru.mycharacter.entity.SkillNodeDependencyId;

public interface SkillNodeDependencyRepository extends JpaRepository<SkillNodeDependencyEntity, SkillNodeDependencyId> {
}
