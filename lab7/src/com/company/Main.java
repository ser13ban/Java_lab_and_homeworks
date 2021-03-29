package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token(1,4,2));
        tokens.add(new Token(1,2,1));
        tokens.add(new Token(2,3,4));
        tokens.add(new Token(3,6,1));
        tokens.add(new Token(6,1,3));
        tokens.add(new Token(4,5,2));
        tokens.add(new Token(5,2,2));

        Game game = new Game();

        game.setBoard(new Board(tokens));

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.startGame();
    }
}
