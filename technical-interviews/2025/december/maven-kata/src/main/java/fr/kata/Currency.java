package fr.kata;

public record Currency(String label) {
    public Currency() {
        this("Dollar");
    }
}
