package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mycharacter.entity.QuestEntity;

import java.util.List;

public interface QuestRepository extends JpaRepository<QuestEntity, Long> {

    @Query("""
            select q
            from QuestEntity q
            join fetch q.branch
            order by q.branch.id, q.id
            """)
    List<QuestEntity> findAllWithBranch();

    @Query("""
            select q
            from QuestEntity q
            join fetch q.branch
            where q.branch.id = :branchId
            order by q.id
            """)
    List<QuestEntity> findByBranchIdWithBranch(@Param("branchId") Long branchId);
}
