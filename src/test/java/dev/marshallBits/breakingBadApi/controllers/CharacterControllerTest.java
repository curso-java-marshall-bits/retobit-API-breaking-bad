package dev.marshallBits.breakingBadApi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marshallBits.breakingBadApi.dto.CharacterDTO;
import dev.marshallBits.breakingBadApi.dto.CreateCharacterDTO;
import dev.marshallBits.breakingBadApi.models.CharacterStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // Configura MockMvc para pruebas de controladores
@Transactional // Asegura que las transacciones se manejen correctamente en pruebas
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Debe obtener todos los personajes correctamente")
    void shouldGetAllCharacters() throws Exception {
        mockMvc.perform(get("/api/characters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Walter White"))
                .andExpect(jsonPath("$[1].name").value("Jesse Pinkman"));
    }

    @Test
    @DisplayName("Debe crear un nuevo personaje correctamente")
    void shouldCreateCharacter() throws Exception {
        CreateCharacterDTO createDTO = new CreateCharacterDTO("Saul Goodman", "Lawyer", CharacterStatus.ALIVE, "saul.jpg");
        CharacterDTO responseDTO = new CharacterDTO(3L, "Saul Goodman", "Lawyer", CharacterStatus.ALIVE, "saul.jpg");

        mockMvc.perform(post("/api/characters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Saul Goodman"))
                .andExpect(jsonPath("$.status").value("ALIVE"));
    }

    @Test
    @DisplayName("Debe obtener un personaje por ID correctamente")
    void shouldGetCharacterById() throws Exception {
        Long characterId = 1L;

        mockMvc.perform(get("/api/characters/{id}", characterId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Walter White"))
                .andExpect(jsonPath("$.status").value("DEAD"));
    }

    @Test
    @DisplayName("Debe devolver 404 cuando el personaje no existe")
    void shouldReturnNotFoundWhenCharacterDoesNotExist() throws Exception {
        Long nonExistentId = 999L;

        mockMvc.perform(get("/api/characters/{id}", nonExistentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Debe actualizar el estado del personaje a DEAD correctamente")
    void shouldUpdateCharacterStatusToDead() throws Exception {
        Long characterId = 1L;
        CharacterDTO updatedCharacter = new CharacterDTO(1L, "Walter White", "High School Chemistry Teacher", CharacterStatus.DEAD, "walter.jpg");

        mockMvc.perform(patch("/api/characters/{id}/status", characterId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("DEAD"));
    }

    @Test
    @DisplayName("Debe devolver 404 al actualizar un personaje inexistente")
    void shouldReturnNotFoundWhenUpdatingNonExistentCharacter() throws Exception {
        Long nonExistentId = 999L;

        mockMvc.perform(patch("/api/characters/{id}/status", nonExistentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Debe devolver 400 al crear un personaje con datos inválidos")
    void shouldReturnBadRequestWhenCreateCharacterWithInvalidData() throws Exception {
        CreateCharacterDTO invalidDTO = new CreateCharacterDTO("", "", null, "");

        mockMvc.perform(post("/api/characters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidDTO)))
                .andExpect(status().isBadRequest());
    }
}
