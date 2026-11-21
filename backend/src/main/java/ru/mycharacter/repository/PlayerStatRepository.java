package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.PlayerStatEntity;

import java.util.List;
import java.util.Optional;

public interface PlayerStatRepository extends JpaRepository<PlayerStatEntity, Long> {
    List<PlayerStatEntity> findByPlayerId(Long playerId);

    Optional<PlayerStatEntity> findByPlayerIdAndStatCode(Long playerId, String statCode);
}
