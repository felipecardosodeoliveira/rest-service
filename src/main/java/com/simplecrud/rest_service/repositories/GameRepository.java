package com.simplecrud.rest_service.repositories;
import com.simplecrud.rest_service.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
