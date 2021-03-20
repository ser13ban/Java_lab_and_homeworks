package com.company.commands;

import com.company.Catalog;

public class PlayCommand extends Command {
    public PlayCommand(Catalog c, String name) {
        c.play(name);
    }
}
