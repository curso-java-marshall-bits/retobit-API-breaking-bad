package dev.marshallBits.breakingBadApi.exceptions;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(String message) {
        super(message);
    }

    public CharacterNotFoundException(Long id) {
        super("Personaje con ID " + id + " no encontrado");
    }
}
