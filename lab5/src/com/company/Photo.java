package com.company;

import java.io.Serializable;
import java.nio.file.Path;

public class Photo extends Item  {
    private String path;
    private String name;
    public Photo(String path, String name) {
        this.path = path;
        this.name = name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
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
