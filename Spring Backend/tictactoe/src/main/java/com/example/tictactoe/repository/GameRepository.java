package com.example.tictactoe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tictactoe.models.Game;

public interface GameRepository extends MongoRepository<Game, String> {
}
