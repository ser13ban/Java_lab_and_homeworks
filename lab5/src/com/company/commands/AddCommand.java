package com.company.commands;

import com.company.Catalog;

public class AddCommand extends Command {
    public AddCommand(Catalog c, String link, String name) {
        c.add(link,name);
    }
}
