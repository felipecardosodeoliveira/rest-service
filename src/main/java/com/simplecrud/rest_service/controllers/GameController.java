package com.simplecrud.rest_service.controllers;

import com.simplecrud.rest_service.dto.GameDTO;
import com.simplecrud.rest_service.dto.GameMinDTO;
import com.simplecrud.rest_service.entities.Game;
import com.simplecrud.rest_service.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Game updatedGame) {
        gameService.update(id, updatedGame);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}

