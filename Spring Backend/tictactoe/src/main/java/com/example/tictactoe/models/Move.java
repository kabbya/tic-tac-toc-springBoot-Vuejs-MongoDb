package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter @AllArgsConstructor
public class Move {

    private int moveSerial;
    private int x;
    private int y;
    private boolean isHighlighted;
    private String value;

    @Override
    public String toString() {
        return "Move{" +
                "moveSerial=" + moveSerial +
                ", x=" + x +
                ", y=" + y +
                ", isHighlighted=" + isHighlighted +
                ", value='" + value + '\'' +
                '}';
    }
}
