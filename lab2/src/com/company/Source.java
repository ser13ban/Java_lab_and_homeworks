package com.company;

import java.util.Objects;

public class Source {
    private String name;
    private Type type;
    private int supply;

    public Source(String name,Type type, int supply) {
        this.type = type;
        this.supply = supply;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSupply() {
        return supply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return "Source{" +
                "type=" + type +
                ", supply=" + supply +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name) && type == source.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, supply);
    }
}
