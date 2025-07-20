package dev.marshallBits.breakingBadApi.controllers;

import dev.marshallBits.breakingBadApi.dto.CharacterDTO;
import dev.marshallBits.breakingBadApi.dto.CreateCharacterDTO;
import dev.marshallBits.breakingBadApi.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    // ✅ IMPLEMENTADO: Obtener todos los personajes
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getAllCharacters() {
        return characterService.findAll();
    }

    // ✅ IMPLEMENTADO: Crear nuevo personaje
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterDTO createCharacter(@Valid @RequestBody CreateCharacterDTO createCharacterDTO) {
        return characterService.createCharacter(createCharacterDTO);
    }

    // 🔧 TODO: Obtener personaje por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        // Usar characterService.findById(id)
        throw new UnsupportedOperationException("¡Implementa este endpoint!");
    }

    // 🔧 TODO: Cambiar estado de Alive a Dead
    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO updateCharacterStatus(@PathVariable Long id) {
        // Usar characterService.updateStatusToDead(id)
        throw new UnsupportedOperationException("¡Implementa este endpoint!");
    }
}
