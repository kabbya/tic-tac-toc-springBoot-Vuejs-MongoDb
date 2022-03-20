package com.example.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.services.GameService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class GameController {
	
	@Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public ResponseEntity<?> addGame(@RequestBody Game game){
        int gameInProgress = 4;
        int findGameResult = this.gameService.findGameResult(game);
         if(findGameResult!=gameInProgress){
            Game save = this.gameRepository.save(game);
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.ok(game);
    }


}
