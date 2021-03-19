package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;

public class Catalog  implements Serializable {
    private List<Item> items;
    Catalog(){
        this.items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(String p, String name){
        try{
            for (Item i: items
            ) {
                if(i.getName() == name){
                    throw new AlreadyExistsException("File with the name " + name + " Already exists!");
                }
            }
            if (p.endsWith(".jpg") || p.endsWith(".png")){
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
    public void play(String name){
        for (Item i: this.items
             ) {
            if (i.getName().equals(name)){
                File f = new File(i.getPath());
                try {
                    Desktop.getDesktop().open(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void save() throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(new File("D:\\Proiecte_java\\java\\lab5\\catalog.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(items);
        System.out.println("The items are saved to the file catalog.txt");
    }

    public void load(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        items = (List<Item>)in.readObject();
        System.out.println("Load completed Succesfully");
    }
}
