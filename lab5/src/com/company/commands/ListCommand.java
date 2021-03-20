package com.company.commands;

import com.company.Catalog;

public class ListCommand extends Command {
    public ListCommand(Catalog catalog) {
        catalog.list();
    }
}
