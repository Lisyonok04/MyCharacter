package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.PlayerBranchEntity;

import java.util.List;

public interface PlayerBranchRepository extends JpaRepository<PlayerBranchEntity, Long> {
    @EntityGraph(attributePaths = {"branch"})
    List<PlayerBranchEntity> findByPlayerId(Long playerId);
}