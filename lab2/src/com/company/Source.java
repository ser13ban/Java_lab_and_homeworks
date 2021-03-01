package com.company;

import java.util.Objects;

abstract public class Source {
    private String name;
    private int supply;

    public Source(){

    }
    public  Source(String name, int supply) {
        this.supply = supply;
        this.name = name;
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
                ", supply=" + supply +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supply);
    }
}
