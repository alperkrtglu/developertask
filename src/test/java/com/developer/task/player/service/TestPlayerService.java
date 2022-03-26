package com.developer.task.player.service;

import com.developer.task.common.constant.Constant;
import com.developer.task.common.exception.MaximumTeamPlayerException;
import com.developer.task.player.entity.Player;
import com.developer.task.player.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class TestPlayerService {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    private Player player = new Player();

    @Test
    void testAddPlayer() {
        when(playerRepository.findAll()).thenReturn(Collections.emptyList());

        playerService.addPlayer(player);

        verify(playerRepository).save(player);
        verify(playerRepository).findAll();
        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void testAddPlayerTeamMax() {
        when(playerRepository.findAll()).thenReturn(Collections.nCopies(Constant.MAX_NUMBER_PLAYER, player));

        assertThrows(MaximumTeamPlayerException.class, () -> playerService.addPlayer(player));

        verify(playerRepository).findAll();
        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void testDeletePlayer() {
        long id = 1L;

        when(playerRepository.deleteByIdEquals(id)).thenReturn(id);

        playerService.deletePlayer(id);

        verify(playerRepository).deleteByIdEquals(id);
        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void testGetPlayers() {
        when(playerRepository.findAll()).thenReturn(Collections.emptyList());

        playerService.getPlayers();

        verify(playerRepository).findAll();
        verifyNoMoreInteractions(playerRepository);
    }
}
