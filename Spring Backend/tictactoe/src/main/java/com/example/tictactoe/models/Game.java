package com.example.tictactoe.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter @AllArgsConstructor
@Document(collection = "games")
public class Game {

    @Id
    private String id;
    private int gridSize;
    private String player1;
    private String player2;
    private String gameResult;
    private int gameVerdict;

    private List<Move> moves;

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", gridSize=" + gridSize +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", gameResult='" + gameResult + '\'' +
                ", gameVerdict='" + gameVerdict + '\'' +
                ", moves=" + moves +
                '}';
    }
}
