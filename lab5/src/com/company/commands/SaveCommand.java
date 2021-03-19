package com.company.commands;

import com.company.Catalog;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand() {
    }
    public void Save(Catalog c){
        try {
            c.save();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
    }
}
