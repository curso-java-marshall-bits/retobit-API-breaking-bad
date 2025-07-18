package dev.marshallBits.breakingBadApi.models;

public enum CharacterStatus {
    ALIVE("Vivo"),
    DEAD("Muerto");

    private final String displayName;

    CharacterStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
