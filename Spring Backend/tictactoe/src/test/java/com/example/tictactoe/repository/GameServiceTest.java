package com.example.tictactoe.repository;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
		
		Game game = new Game("1", 5, "Player1", "Player2", "X Wins the Game.", 1, list);
		
		when(gameRepository.save(game)).thenReturn(game);
        Assert.assertEquals(gameServiceImpl.addGame(game), game);
	}
	
	
	@Test
	public void getGameTest() {
		
		Move game1move0 = new Move(0, 5, 5, false, "X");
		Move game1move1 = new Move(1, 1, 1, false, "X");
		Move game1move2 = new Move(2, 2, 2, false, "X");
		Move game1move3 = new Move(3, 3, 3, false, "X");
		List<Move> movelistGame1 = new ArrayList<Move>();
		movelistGame1.add(game1move0);
		movelistGame1.add(game1move1);
		movelistGame1.add(game1move2);
		movelistGame1.add(game1move3);
		
		Game game1 = new Game("1", 5, "Player1", "Player2", "X Wins the Game.", 1, movelistGame1);
		
		Move game2move0 = new Move(0, 8, 8, false, "X");
		Move game2move1 = new Move(1, 3, 3, false, "O");
		Move game2move2 = new Move(2, 4, 4, false, "O");
		Move game2move3 = new Move(3, 5, 5, false, "O");
		List<Move> moveListGame2 = new ArrayList<Move>();
		moveListGame2.add(game2move0);
		moveListGame2.add(game2move1);
		moveListGame2.add(game2move2);
		moveListGame2.add(game2move3);
		
		Game game2 = new Game("2", 8, "Player1", "Player2", "O Wins the Game.", 2, moveListGame2);
		
		List<Game> allGameList = new ArrayList<Game>();
		allGameList.add(game1);
		allGameList.add(game2);
		
		when(gameRepository.findAll()).thenReturn(allGameList);
	    Assert.assertEquals(gameServiceImpl.getGame(), allGameList);
	}
	
	

	@Test
	public void findGameResultCrossWinsDiagonallyTest() {
		Move move0 = new Move(0, 5, 5, false, "X");
		Move move1 = new Move(1, 1, 1, false, "X");
		Move move2 = new Move(2, 2, 2, false, "X");
		Move move3 = new Move(3, 3, 3, false, "X");
		List<Move> list = new ArrayList<Move>();
		list.add(move0);
		list.add(move1);
		list.add(move2);
		list.add(move3);
		
		int expectedGameResult = 1;
		int actualGameResult = gameServiceImpl.findGameResult(new Game("1", 5, "Player1", "Player2", null, 0, list));

		assertThat(actualGameResult).isEqualTo(expectedGameResult);
	}
	
	@Test
	public void findGameResultCrossWinsRowTest() {
		Move move0 = new Move(0, 5, 5, false, "X");
		Move move1 = new Move(1, 1, 1, false, "X");
		Move move2 = new Move(2, 1, 2, false, "X");
		Move move3 = new Move(3, 1, 3, false, "X");
		List<Move> list = new ArrayList<Move>();
		list.add(move0);
		list.add(move1);
		list.add(move2);
		list.add(move3);
		
		int expectedGameResult = 1;
		int actualGameResult = gameServiceImpl.findGameResult(new Game("1", 5, "Player1", "Player2", null, 0, list));

		assertThat(actualGameResult).isEqualTo(expectedGameResult);
	}
	
	
	@Test
	public void findGameResultCrossWinsColumnTest() {
		Move move0 = new Move(0, 5, 5, false, "X");
		Move move1 = new Move(1, 1, 1, false, "X");
		Move move2 = new Move(2, 2, 1, false, "X");
		Move move3 = new Move(3, 3, 1, false, "X");
		List<Move> list = new ArrayList<Move>();
		list.add(move0);
		list.add(move1);
		list.add(move2);
		list.add(move3);
		
		int expectedGameResult = 1;
		int actualGameResult = gameServiceImpl.findGameResult(new Game("1", 5, "Player1", "Player2", null, 0, list));

		assertThat(actualGameResult).isEqualTo(expectedGameResult);
	}
	

	
	
}
