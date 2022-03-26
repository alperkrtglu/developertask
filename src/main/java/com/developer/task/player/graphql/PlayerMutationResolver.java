package com.developer.task.player.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.developer.task.player.dto.PlayerDto;
import com.developer.task.player.dto.mapper.PlayerMapper;
import com.developer.task.player.entity.Player;
import com.developer.task.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;

    public Player addPlayer(PlayerDto dto) {
        return playerService.addPlayer(PlayerMapper.INSTANCE.dtoToEntity(dto));
    }

    public Long deletePlayer(Long id) {
        return playerService.deletePlayer(id);
    }

}
