package edu.livreny.api.model;

public enum Genre {
    HORROR("Horror"),
    FANTASY("Fantasy"),
    CLASSIC("Classic");

    private final String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
