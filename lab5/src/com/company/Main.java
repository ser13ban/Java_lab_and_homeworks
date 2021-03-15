package com.company;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Catalog c = new Catalog();
        c.add(Path.of("C:\\Users\\Mihai\\Pictures\\moon_tree_starry_sky_132139_1920x1080.jpg"), "picture1");
        c.add(Path.of("C:\\Users\\Mihai\\Videos\\2021-02-24 10-03-39.mkv"),"picture1");
        c.list();
        //c.Play("video1");
    }
}
