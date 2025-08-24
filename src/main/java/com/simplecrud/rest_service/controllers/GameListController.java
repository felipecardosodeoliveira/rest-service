package com.simplecrud.rest_service.controllers;

import com.simplecrud.rest_service.dto.GameListDTO;
import com.simplecrud.rest_service.dto.GameMinDTO;
import com.simplecrud.rest_service.entities.GameList;
import com.simplecrud.rest_service.services.GameListService;
import com.simplecrud.rest_service.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody GameList gameList) {
        gameListService.update(id, gameList);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        gameListService.delete(id);
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> findByList(@PathVariable Long id) {
        return gameService.findByList(id);
    }

}
