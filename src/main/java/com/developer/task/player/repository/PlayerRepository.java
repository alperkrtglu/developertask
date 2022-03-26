package com.developer.task.player.repository;

import com.developer.task.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Long deleteByIdEquals(Long id);

}
