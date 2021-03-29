package com.company;

public class Player implements Runnable{
    private String name;
    private Board board;
    private Game game;

    Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //choose a token with a board or something like that
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
