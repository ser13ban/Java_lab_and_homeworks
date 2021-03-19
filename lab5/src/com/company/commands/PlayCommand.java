package com.company.commands;

import com.company.Catalog;

public class PlayCommand extends Command {
    public PlayCommand() {
    }
    public void play(Catalog c, String name){
        c.play(name);
    }
}
