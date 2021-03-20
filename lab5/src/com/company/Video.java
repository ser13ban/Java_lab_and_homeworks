package com.company;

import java.nio.file.Path;

public class Video extends Item{
    public Video(String path, String name) {
        this.setPath(path);
        this.setName(name);
    }
    @Override
    public String toString() {
        return "Item{" +
                "path='" + this.getPath() + '\'' +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
