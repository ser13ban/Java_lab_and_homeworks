package com.company;

import java.nio.file.Path;

public class Photo extends Item{
    private Path path;
    private String name;
    public Photo(Path path, String name) {
        this.path = path;
        this.name = name;
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
