package com.developer.task.player.dto.mapper;

import com.developer.task.player.dto.PlayerDto;
import com.developer.task.player.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    Player dtoToEntity(PlayerDto dto);

}
