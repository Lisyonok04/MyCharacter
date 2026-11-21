package ru.mycharacter.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mycharacter.entity.PlayerBranchEntity;

import java.util.List;
import java.util.Optional;

public interface PlayerBranchRepository extends JpaRepository<PlayerBranchEntity, Long> {

    @EntityGraph(attributePaths = {"branch"})
    List<PlayerBranchEntity> findByPlayerId(Long playerId);

    @Query("""
            select pb
            from PlayerBranchEntity pb
            join fetch pb.branch
            where pb.playerId = :playerId and pb.branch.id = :branchId
            """)
    Optional<PlayerBranchEntity> findByPlayerIdAndBranchId(
            @Param("playerId") Long playerId,
            @Param("branchId") Long branchId
    );

    @Modifying
    @Query("""
            delete from PlayerBranchEntity pb
            where pb.playerId = :playerId and pb.branch.id not in :branchIds
            """)
    void deleteByPlayerIdAndBranchIdNotIn(
            @Param("playerId") Long playerId,
            @Param("branchIds") List<Long> branchIds
    );
}
