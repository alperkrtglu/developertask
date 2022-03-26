package com.developer.task.player.service;

import com.developer.task.common.constant.Constant;
import com.developer.task.common.exception.MaximumTeamPlayerException;
import com.developer.task.player.entity.Player;
import com.developer.task.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional
    public Player addPlayer(Player player) {
        if (isTeamCapacityMax()) {
            throw new MaximumTeamPlayerException("The number of players reached its max.");
        }

        return playerRepository.save(player);
    }

    private boolean isTeamCapacityMax() {
        return getPlayers().size() == Constant.MAX_NUMBER_PLAYER;
    }

    @Transactional
    public Long deletePlayer(Long id) {
        return playerRepository.deleteByIdEquals(id);
    }

    @Transactional(readOnly = true)
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

}
