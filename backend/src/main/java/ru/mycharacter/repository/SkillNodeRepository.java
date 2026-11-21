package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mycharacter.entity.SkillNodeEntity;

import java.util.List;

public interface SkillNodeRepository extends JpaRepository<SkillNodeEntity, Long> {

    @Query("""
            select n
            from SkillNodeEntity n
            join fetch n.branch
            order by n.branch.id, n.sortOrder, n.id
            """)
    List<SkillNodeEntity> findAllWithBranch();
}
