package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void startGame() {
        for( Player p : players ) {
            new Thread(p).start();
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
