package com.developer.task.player.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.developer.task.player.entity.Player;
import com.developer.task.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerService playerService;

    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

}
