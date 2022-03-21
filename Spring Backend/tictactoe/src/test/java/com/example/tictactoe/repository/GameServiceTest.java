package com.example.tictactoe.repository;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Move;
import com.example.tictactoe.services.GameServiceImpl;


@SpringBootTest
public class GameServiceTest {
	
	@InjectMocks
	private GameServiceImpl gameServiceImpl;
	
	@Mock
	private GameRepository gameRepository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void addGameTest() {
		Move move0 = new Move(0, 5, 5, false, "X");
		Move move1 = new Move(1, 1, 1, false, "X");
		Move move2 = new Move(2, 2, 2, false, "X");
		Move move3 = new Move(3, 3, 3, false, "X");
		List<Move> list = new ArrayList<Move>();
		list.add(move0);
		list.add(move1);
		list.add(move2);
		list.add(move3);
		
		Game game = new Game("1", 5, "Player1", "Player2", null, 0, list);
		
		when(gameRepository.save(game)).thenReturn(game);
        Assert.assertEquals(gameServiceImpl.addGame(game), game);
	}
	
}
