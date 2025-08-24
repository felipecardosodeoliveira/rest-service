package com.simplecrud.rest_service.services;

import com.simplecrud.rest_service.dto.GameListDTO;
import com.simplecrud.rest_service.entities.GameList;
import com.simplecrud.rest_service.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository
                .findAll()
                .stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        return gameListRepository
                .findById(id)
                .map(GameListDTO::new)
                .orElseThrow(() -> new RuntimeException("List item not found"));
    }

    @Transactional()
    public void update(Long id, GameList gameListUpdated) {
        var gameList = gameListRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("List item not found"));
        gameList.setName(gameListUpdated.getName());
        gameListRepository.save(gameList);
    }

    @Transactional()
    public void delete(Long id) {
        var gameList = gameListRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("List item not found"));
        gameListRepository.delete(gameList);
    }

}
