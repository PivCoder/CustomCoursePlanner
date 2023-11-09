package com.example.customcourseplanner.model.enums;

public enum Role {
    USER("Пользователь"),
    ADMIN("Администратор"),
    MODERATOR("Модератор"),
    MENTOR("Ментор"),
    GUEST("Гость");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
