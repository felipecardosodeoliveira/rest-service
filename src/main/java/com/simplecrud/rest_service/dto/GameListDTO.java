package com.simplecrud.rest_service.dto;

import com.simplecrud.rest_service.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {}

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
