package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int n;
    private List<Token> board = new ArrayList<Token>();

    Board(List<Token> tokens){
        this.board = tokens;
        this.n = tokens.size();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Token> getBoard() {
        return board;
    }

    public void setBoard(List<Token> board) {
        this.board = board;
    }
}
