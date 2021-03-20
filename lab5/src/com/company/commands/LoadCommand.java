package com.company.commands;

import com.company.Catalog;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadCommand extends Command {
    public LoadCommand(Catalog c, String path) {
        try {
            c.load(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
