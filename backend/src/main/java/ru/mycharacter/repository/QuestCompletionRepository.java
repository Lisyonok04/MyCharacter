package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.QuestCompletionEntity;

import java.time.LocalDate;

public interface QuestCompletionRepository extends JpaRepository<QuestCompletionEntity, Long> {
    boolean existsByPlayerIdAndQuestIdAndCompletionDate(Long playerId, Long questId, LocalDate completionDate);
}
