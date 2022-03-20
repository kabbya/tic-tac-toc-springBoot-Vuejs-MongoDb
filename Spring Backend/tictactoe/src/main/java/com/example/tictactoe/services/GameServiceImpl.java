package com.example.tictactoe.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Move;

@Service
public class GameServiceImpl implements GameService{

    private int winningMoveSerial = 0;
    List<Move> winningMoves = new ArrayList<>();

    @Override
    public boolean isValidIndex(int x, int y, int boardSize) {
        return x>=0 && x<boardSize && y>=0 && y<boardSize;
    }

    @Override
    public boolean checkIsNull(Move move) {
        if(move==null)
            return  true;
        return  false;
    }


    @Override
    public boolean calculateWinningMoveSerial(int maxMoveSerial) {
        if(winningMoveSerial==0) {
            winningMoveSerial = maxMoveSerial;
            return  true;
        }
        else {
            if(maxMoveSerial < winningMoveSerial) {
                winningMoveSerial = maxMoveSerial;
                return true;
            }else{
                return  false;
            }
        }
    }

    @Override
    public void isThreeIndexMatching(Move[][] board, int x1, int y1, int x2, int y2, int x3, int y3) {
        int boardSize = board[0].length;
        if(isValidIndex(x1,y1,boardSize) && isValidIndex(x2,y2,boardSize) && isValidIndex(x3,y3,boardSize)) {
            if( checkIsNull(board[x1][y1])==true || checkIsNull(board[x2][y2])==true || checkIsNull(board[x3][y3])==true)
                return;
            String currentValue = board[x1][y1].getValue();
            if (currentValue.equals(board[x2][y2].getValue()) && currentValue.equals(board[x3][y3].getValue())) {
                int maxMoveSerial = Math.max(board[x1][y1].getMoveSerial(), Math.max(board[x2][y2].getMoveSerial(), board[x3][y3].getMoveSerial()));
                if( calculateWinningMoveSerial(maxMoveSerial) ){
                    if(winningMoves.isEmpty() == false) {
                        winningMoves.clear();
                    }
                    winningMoves.add(board[x1][y1]);
                    winningMoves.add(board[x2][y2]);
                    winningMoves.add(board[x3][y3]);
                }
            }
        }
    }

    @Override
    public void calculateRightDiagonalMatch(Move[][] board, int x1, int y1) {
        int x2 = x1-1;
        int y2= y1+1;
        int x3 = x2-1;
        int y3= y2+1;
        isThreeIndexMatching(board, x1, y1, x2, y2, x3, y3);
    }

    @Override
    public void calculateLeftDiagonalMatch(Move[][] board, int x1, int y1) {
        int x2 = x1-1;
        int y2= y1-1;
        int x3 = x2-1;
        int y3= y2-1;
        isThreeIndexMatching(board, x1, y1, x2, y2, x3, y3);
    }

    @Override
    public void calculateRowMatch(Move[][] board, int x1, int y1) {
        int x2 = x1;
        int y2= y1-1;
        int x3 = x1;
        int y3= y2-1;
        isThreeIndexMatching(board, x1, y1, x2, y2, x3, y3);
    }

    @Override
    public void calculateColumnMatch(Move[][] board, int x1, int y1) {
        int x2 = x1-1;
        int y2= y1;
        int x3 = x2-1;
        int y3= y1;
        isThreeIndexMatching(board, x1, y1, x2, y2, x3, y3);
    }

    @Override
    public int findWinner(List<Move> moves) {
        if( moves.get(winningMoveSerial).getValue().equals(moves.get(0).getValue()))
            return 1;
        return  2;
    }


    @Override
    public int isGameDraw(int boardSize, List<Move> moves) {
        if( moves.size()-1 == boardSize*boardSize )
            return 3;
        return  4;
    }

    @Override
    public int calculateGameVerdict(int boardSize, List<Move> moves) {
        if( winningMoveSerial!=0 )
            return findWinner(moves);
        return  isGameDraw(boardSize, moves);
    }

    @Override
    public void makeHighlightedTrue(Game game) {
        for(int i=0; i<3; i++){
            int winningBlockSerial = winningMoves.get(i).getMoveSerial();
            game.getMoves().get(winningBlockSerial).setHighlighted(true);
        }
    }

    @Override
    public void setGameResult(Game game, int gameVerdict) {
        int xWin = 1;
        int oWin = 2;
        int draw = 3;

        if(gameVerdict==xWin){
            game.setGameResult("X Wins the Game.");
            makeHighlightedTrue(game);
        }else if(gameVerdict==oWin){
            game.setGameResult("O Wins the Game.");
            makeHighlightedTrue(game);
        }else{
            game.setGameResult("It's a draw.");
        }
        return;
    }



    @Override
    public int findGameResult(Game game) {
        winningMoveSerial = 0;
        if(winningMoves.isEmpty() == false) {
            winningMoves.clear();
        }
        int boardSize = game.getGridSize();
        List <Move> moves = game.getMoves();
        Move[][] board = makeBoard(boardSize, game.getMoves());
        for(int i=1; i<moves.size(); i++){
            int x = moves.get(i).getX();
            int y = moves.get(i).getY();
            calculateRightDiagonalMatch(board, x, y);
            calculateLeftDiagonalMatch(board, x, y);
            calculateRowMatch(board, x, y);
            calculateColumnMatch(board, x, y);
        }

        int gameVerdict = calculateGameVerdict(boardSize, game.getMoves());
        game.setGameVerdict(gameVerdict);

        int matchInProgress = 4;
        if(gameVerdict!=matchInProgress) {
            setGameResult(game, gameVerdict);
        }


        return  gameVerdict;
    }


    @Override
    public Move[][] makeBoard(int boardSize, List<Move> moves) {
        Move[][] board = new Move[boardSize][boardSize];
        for(int i=1; i<moves.size(); i++){
            int x = moves.get(i).getX();
            int y = moves.get(i).getY();
            board[x][y] = moves.get(i);
        }
        return  board;
    }


}
