package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mycharacter.entity.DevelopmentBranchEntity;

import java.util.List;

public interface DevelopmentBranchRepository extends JpaRepository<DevelopmentBranchEntity, Long> {

    @Query("select b from DevelopmentBranchEntity b where b.isActive = true order by b.id")
    List<DevelopmentBranchEntity> findActiveBranches();

    @Query("select b from DevelopmentBranchEntity b where b.id in :ids and b.isActive = true")
    List<DevelopmentBranchEntity> findActiveByIds(@Param("ids") List<Long> ids);
}
