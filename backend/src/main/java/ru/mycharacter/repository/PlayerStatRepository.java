package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.PlayerStatEntity;

import java.util.List;

public interface PlayerStatRepository extends JpaRepository<PlayerStatEntity, Long> {
    List<PlayerStatEntity> findByPlayerId(Long playerId);
}