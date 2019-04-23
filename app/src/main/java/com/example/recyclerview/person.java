package com.example.recyclerview;

public class person {
    private String name;
    private String surname;
    private String preferance;


    public person(String name, String surname, String preferance) {
        this.name = name;
        this.surname = surname;
        this.preferance = preferance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreferance() {
        return preferance;
    }

    public void setPreferance(String preferance) {
        this.preferance = preferance;
    }

    public Object setPreferance() {
        return null;
    }
}
