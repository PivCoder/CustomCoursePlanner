package com.example.customcourseplanner.model.enums;

public enum MaterialType {
    VIDEO("Ссылка на видео"),
    FILE("Ссылка на файл"),
    INTERNET_RESOURCE("Ссылка на ресурс в интернете");

    private final String description;

    MaterialType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
