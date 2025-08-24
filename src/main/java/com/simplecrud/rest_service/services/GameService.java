package com.simplecrud.rest_service.services;

import com.simplecrud.rest_service.dto.GameMinDTO;
import com.simplecrud.rest_service.dto.GameDTO;
import com.simplecrud.rest_service.entities.Game;
import com.simplecrud.rest_service.projections.GameMinProjection;
import com.simplecrud.rest_service.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return gameRepository
                .findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new RuntimeException("Game not found!"));
    }

    public void update(Long id, Game updatedGame) {
        var game = gameRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found!"));
        game.setTitle(updatedGame.getTitle());
        game.setYear(updatedGame.getYear());
        game.setGenre(updatedGame.getGenre());
        game.setPlatforms(updatedGame.getPlatforms());
        game.setScore(updatedGame.getScore());
        game.setImageUrl(updatedGame.getImageUrl());
        game.setShortDescription(updatedGame.getShortDescription());
        game.setLongDescription(updatedGame.getLongDescription());
        gameRepository.save(game);
    }

    public void delete(Long id) {
        var game = gameRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found!"));
        gameRepository.delete(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long id) {
        return gameRepository
                .searchByList(id)
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }
}
