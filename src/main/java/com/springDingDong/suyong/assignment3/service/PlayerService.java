package com.springDingDong.suyong.assignment3.service;

import com.springDingDong.suyong.assignment2.Entity.Player;
import com.springDingDong.suyong.assignment2.Repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional
    public Long contractPlayer(Player player) {
        validateDuplicatePlayer(player);
        playerRepository.contractPlayer(player);
        return player.getId();
    }

    private void validateDuplicatePlayer(Player player) {
        List<Player> findPlayers = playerRepository.findByName(player.getName());
        if (!findPlayers.isEmpty()) {
            throw new IllegalArgumentException("이미 팀에 존재하는 선수입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<Player> findPlayers() { return playerRepository.findAll(); }

    @Transactional(readOnly = true)
    public Player findPlayer(Long playerId) { return playerRepository.findOne(playerId); }

    @Transactional
    public void updateBackNumber(Long playerId, int newBackNumber) {
        int updatedRows = playerRepository.updateBackNumber(playerId, newBackNumber);
        if (updatedRows == 0) {
            throw new IllegalArgumentException("해당 선수의 ID가 존재하지 않습니다.");
        }
    }

    public int releasePlayer(Long playerId) {
        return playerRepository.releasePlayer(playerId);
    }
}
