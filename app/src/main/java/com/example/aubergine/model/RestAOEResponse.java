package com.example.aubergine.model;

import java.util.List;

public class RestAOEResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<AOE> civilizations;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() { return next; }

    public void setNext(String next) { this.next = next; }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<AOE> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<AOE> civilizations) {
        this.civilizations = civilizations;
    }
}
