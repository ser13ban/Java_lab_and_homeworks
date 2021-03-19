package com.company.commands;

import com.company.Catalog;

public class ListCommand extends Command {
    public ListCommand() {
    }

    public void list(Catalog c){
        c.list();
    }
}
