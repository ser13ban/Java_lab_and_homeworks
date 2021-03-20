package com.company;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String path;
    private String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
