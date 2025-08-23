package com.simplecrud.rest_service.services;

import com.simplecrud.rest_service.dto.GameMinDTO;
import com.simplecrud.rest_service.entities.Game;
import com.simplecrud.rest_service.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

}
