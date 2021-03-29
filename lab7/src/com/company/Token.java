package com.company;

public class Token {
    private Integer iIndex;
    private Integer jIndex;
    private Integer cost;

    public Token(Integer iindex, Integer jindex, Integer cost) {
        iIndex = iindex;
        jIndex = jindex;
        this.cost = cost;
    }

    public Integer getIindex() {
        return iIndex;
    }

    public void setIindex(Integer iindex) {
        iIndex = iindex;
    }

    public Integer getJindex() {
        return jIndex;
    }

    public void setJindex(Integer jindex) {
        jIndex = jindex;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
