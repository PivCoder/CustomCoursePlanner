package com.example.customcourseplanner.model.enums;

public enum Level {
    NO_SKILL("Навык полностью отсутствует"),
    BASIC("Имеются базовые знания"),
    INTERMEDIATE("Средний уровень знаний"),
    GOOD("Хороший уровень знаний"),
    EXCELLENT("Отличный уровень знаний");

    private final String description;

    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
