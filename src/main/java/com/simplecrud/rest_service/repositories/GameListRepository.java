package com.simplecrud.rest_service.repositories;

import com.simplecrud.rest_service.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
