package com.company;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Catalog {
    List<Item> items;
    Catalog(){
        this.items = new ArrayList<Item>();
    }

    public void add(Path p, String name){
        try{
            for (Item i: items
            ) {
                if(i.getName() == name){
                    throw new AlreadyExistsException("File with the name " + name + " Already exists!");
                }
            }
            if (p.toString().endsWith(".jpg") || p.toString().endsWith(".png")){
                Photo photo = new Photo(p,name);
                items.add(photo);
            }
            if(p.toString().endsWith(".mkv") ){
                Video video = new Video(p,name);
                items.add(video);
            }

        } catch (AlreadyExistsException a){
            System.out.println(a);
        }

    }
    public void list(){
        for (Item i: items
             ) {
            System.out.println(i.getName());
        }
    }
    public void Play(String name){
        for (Item i: items
             ) {
            if (i.getName() == name){
                File f = new File(i.getPath().toString());
                try {
                    Desktop.getDesktop().open(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Nu exista acest item (trebuie implementat cu exception)");
    }
}
