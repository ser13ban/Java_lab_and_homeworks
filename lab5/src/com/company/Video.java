package com.company;

import java.nio.file.Path;

public class Video extends Item{
    public Video(Path path, String name) {
        this.setPath(path);
        this.setName(name);
    }
}
