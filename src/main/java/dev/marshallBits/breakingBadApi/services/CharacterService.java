package dev.marshallBits.breakingBadApi.services;

import dev.marshallBits.breakingBadApi.dto.CharacterDTO;
import dev.marshallBits.breakingBadApi.dto.CreateCharacterDTO;

import java.util.List;

public interface CharacterService {

    // ✅ IMPLEMENTADO: Obtener todos los personajes
    List<CharacterDTO> findAll();

    // ✅ IMPLEMENTADO: Crear nuevo personaje
    CharacterDTO createCharacter(CreateCharacterDTO createCharacterDTO);

    // 🔧 PARA COMPLETAR: Obtener personaje por ID
    CharacterDTO findById(Long id);

    // 🔧 PARA COMPLETAR: Cambiar estado de Alive a Dead
    CharacterDTO updateStatusToDead(Long id);
}
