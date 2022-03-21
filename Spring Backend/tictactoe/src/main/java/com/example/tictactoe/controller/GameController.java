package com.example.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.services.GameService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")

public class GameController {
	
    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public ResponseEntity<?> addGame(@RequestBody Game game){
        int gameInProgress = 4;
        int findGameResult = this.gameService.findGameResult(game);
         if(findGameResult!=gameInProgress){
            return ResponseEntity.ok(this.gameService.addGame(game));
        }else {
        	return ResponseEntity.ok(game);   
        }
    }
    
    @GetMapping("/game")
    public ResponseEntity<?> getGame(){
    	List<Game> list = this.gameService.getGame();
    	if (list.size() == 0)
	        return (ResponseEntity<?>) ResponseEntity.noContent();
		else
			 return ResponseEntity.ok(list);
    		
    }
}