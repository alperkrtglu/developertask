package com.developer.task.player.dto;

import com.developer.task.player.enums.PlayerPosition;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlayerDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotNull
    private PlayerPosition position;

}