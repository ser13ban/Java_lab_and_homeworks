package com.company;

public class Audio extends Item{
    private String path;
    private String name;

    public Audio(String path, String name) {
        this.path = path;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
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
    public String toString() {
        return "Item{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
