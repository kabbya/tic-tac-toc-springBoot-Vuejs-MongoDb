package com.example.tictactoe.services;


import java.util.List;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Move;

public interface GameService {

    boolean isValidIndex(int x, int y, int boardSize);
    void calculateRightDiagonalMatch(Move[][] board, int x1, int y1);
    void calculateLeftDiagonalMatch(Move[][] board, int x1, int y1);
    void calculateRowMatch(Move[][] board, int x1, int y1);
    void calculateColumnMatch(Move[][] board, int x1, int y1);
    void isThreeIndexMatching(Move[][] board, int x1, int y1, int x2, int y2, int x3, int y3);
    boolean calculateWinningMoveSerial(int maxMoveSerial);
    int isGameDraw(int boardSize, List<Move> moves);
    int findWinner(List<Move> moves);
    boolean checkIsNull(Move move);
    int calculateGameVerdict(int boardSize, List<Move> moves);
    int findGameResult(Game game);
    void setGameResult(Game game, int gameVerdict);
    void makeHighlightedTrue(Game game);
    Move[][] makeBoard(int boardSize, List<Move> moves);

}
