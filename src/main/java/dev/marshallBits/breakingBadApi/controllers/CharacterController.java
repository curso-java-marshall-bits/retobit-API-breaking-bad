package dev.marshallBits.breakingBadApi.controllers;

import dev.marshallBits.breakingBadApi.dto.CharacterDTO;
import dev.marshallBits.breakingBadApi.dto.CreateCharacterDTO;
import dev.marshallBits.breakingBadApi.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
        List<CharacterDTO> characters = characterService.findAll();
        return ResponseEntity.ok(characters);
    }

    // ✅ IMPLEMENTADO: Crear nuevo personaje
    @PostMapping
    public ResponseEntity<CharacterDTO> createCharacter(@Valid @RequestBody CreateCharacterDTO createCharacterDTO) {
        CharacterDTO character = characterService.createCharacter(createCharacterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

    // 🔧 PARA COMPLETAR: Obtener personaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
        // PISTA: Usar characterService.findById(id)
        throw new UnsupportedOperationException("¡Implementa este endpoint!");
    }

    // 🔧 PARA COMPLETAR: Cambiar estado de Alive a Dead
    @PatchMapping("/{id}/status")
    public ResponseEntity<CharacterDTO> updateCharacterStatus(@PathVariable Long id) {
        // PISTA: Usar characterService.updateStatusToDead(id)
        throw new UnsupportedOperationException("¡Implementa este endpoint!");
    }
}
