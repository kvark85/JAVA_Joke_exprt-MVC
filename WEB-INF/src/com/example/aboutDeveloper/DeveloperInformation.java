package com.example.aboutDeveloper;

public class DeveloperInformation {
    private String name;
    private String email;

    public DeveloperInformation (String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }
}