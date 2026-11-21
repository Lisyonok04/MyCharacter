package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycharacter.entity.QuestStatEntity;

import java.util.List;

public interface QuestStatRepository extends JpaRepository<QuestStatEntity, Long> {
    List<QuestStatEntity> findByQuestId(Long questId);
}
