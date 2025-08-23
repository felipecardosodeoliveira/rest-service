package com.simplecrud.rest_service.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {}

    public Belonging(Game game, GameList list, Integer position) {
        this.position = position;
        this.id.setGame(game);
        this.id.setList(list);
    }
}
