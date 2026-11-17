package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}