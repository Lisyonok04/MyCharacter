package ru.mycharacter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mycharacter.api.models.BranchProgressDto;
import ru.mycharacter.api.models.CharacterProfileResponse;
import ru.mycharacter.api.models.PlayerStatDto;
import ru.mycharacter.entity.PlayerEntity;
import ru.mycharacter.repository.PlayerBranchRepository;
import ru.mycharacter.repository.PlayerRepository;
import ru.mycharacter.repository.PlayerStatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final PlayerRepository playerRepository;
    private final PlayerStatRepository playerStatRepository;
    private final PlayerBranchRepository playerBranchRepository;

    @Transactional(readOnly = true)
    public CharacterProfileResponse getCharacterProfile(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));

        List<PlayerStatDto> stats = playerStatRepository.findByPlayerId(playerId)
                .stream()
                .map(stat -> new PlayerStatDto(
                        stat.getStatCode(),
                        stat.getStatName(),
                        stat.getCurrentValue(),
                        stat.getCurrentXp()
                ))
                .toList();

        List<BranchProgressDto> branches = playerBranchRepository.findByPlayerId(playerId)
                .stream()
                .map(pb -> new BranchProgressDto(
                        pb.getBranch().getId(),
                        pb.getBranch().getCode(),
                        pb.getBranch().getName(),
                        pb.getBranchLevel(),
                        pb.getBranchXp()
                ))
                .toList();

        int nextLevelXp = (int) (100 * Math.pow(player.getLevel(), 1.5));

        return new CharacterProfileResponse(
                player.getId(),
                player.getNickname(),
                player.getCharacterName(),
                player.getLevel(),
                player.getTotalXp(),
                nextLevelXp,
                player.getCurrentStreak(),
                stats,
                branches
        );
    }
}