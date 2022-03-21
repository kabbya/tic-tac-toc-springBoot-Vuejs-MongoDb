package com.example.tictactoe.services;


import java.util.List;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Move;

public interface GameService {
	
	public Game addGame(Game game);
	public List<Game> getGame();
	public boolean isValidIndex(int x, int y, int boardSize);
	public void calculateRightDiagonalMatch(Move[][] board, int x1, int y1);
	public void calculateLeftDiagonalMatch(Move[][] board, int x1, int y1);
	public void calculateRowMatch(Move[][] board, int x1, int y1);
	public void calculateColumnMatch(Move[][] board, int x1, int y1);
	public void isThreeIndexMatching(Move[][] board, int x1, int y1, int x2, int y2, int x3, int y3);
	public boolean calculateWinningMoveSerial(int maxMoveSerial);
	public int isGameDraw(int boardSize, List<Move> moves);
	public int findWinner(List<Move> moves);
	public boolean checkIsNull(Move move);
	public int calculateGameVerdict(int boardSize, List<Move> moves);
	public int findGameResult(Game game);
	public void setGameResult(Game game, int gameVerdict);
	public void makeHighlightedTrue(Game game);
	public Move[][] makeBoard(int boardSize, List<Move> moves);

}
