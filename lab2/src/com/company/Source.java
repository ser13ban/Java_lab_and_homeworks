package com.company;

public class Source {
    private String name;
    private SourceType type;
    private int supply;

    public Source(String name,SourceType type, int supply) {
        this.type = type;
        this.supply = supply;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Source{" +
                "type=" + type +
                ", supply=" + supply +
                '}';
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }
}
