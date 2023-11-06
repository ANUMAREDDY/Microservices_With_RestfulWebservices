package com.example.base.classes;

public class Name {
    private long id;
    private String name;
    private String percentage;

    public Name(long id, String name, String percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }
    public Name(String name) {
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
