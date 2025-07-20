package dev.marshallBits.breakingBadApi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marshallBits.breakingBadApi.dto.CharacterDTO;
import dev.marshallBits.breakingBadApi.dto.CreateCharacterDTO;
import dev.marshallBits.breakingBadApi.exceptions.CharacterNotFoundException;
import dev.marshallBits.breakingBadApi.models.CharacterStatus;
import dev.marshallBits.breakingBadApi.services.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharacterController.class)
@ExtendWith(MockitoExtension.class)
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Debe obtener todos los personajes correctamente")
    void shouldGetAllCharacters() throws Exception {
        List<CharacterDTO> characters = Arrays.asList(
                new CharacterDTO(1L, "Walter White", "High School Chemistry Teacher", CharacterStatus.DEAD, "walter.jpg"),
                new CharacterDTO(2L, "Jesse Pinkman", "Meth Dealer", CharacterStatus.ALIVE, "jesse.jpg")
        );
        when(characterService.findAll()).thenReturn(characters);

        mockMvc.perform(get("/api/characters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Walter White"))
                .andExpect(jsonPath("$[1].name").value("Jesse Pinkman"));
    }

    @Test
    @DisplayName("Debe crear un nuevo personaje correctamente")
    void shouldCreateCharacter() throws Exception {
        CreateCharacterDTO createDTO = new CreateCharacterDTO("Saul Goodman", "Lawyer", CharacterStatus.ALIVE, Arrays.asList(2, 3, 4, 5), "saul.jpg");
        CharacterDTO responseDTO = new CharacterDTO(3L, "Saul Goodman", "Lawyer", CharacterStatus.ALIVE, "saul.jpg");

        when(characterService.createCharacter(any(CreateCharacterDTO.class))).thenReturn(responseDTO);

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
        CharacterDTO character = new CharacterDTO(1L, "Walter White", "High School Chemistry Teacher", CharacterStatus.DEAD, "walter.jpg");
        when(characterService.findById(characterId)).thenReturn(character);

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
        when(characterService.findById(nonExistentId)).thenThrow(new CharacterNotFoundException("Character not found with id: " + nonExistentId));

        mockMvc.perform(get("/api/characters/{id}", nonExistentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Debe actualizar el estado del personaje a DEAD correctamente")
    void shouldUpdateCharacterStatusToDead() throws Exception {
        Long characterId = 1L;
        CharacterDTO updatedCharacter = new CharacterDTO(1L, "Walter White", "High School Chemistry Teacher", CharacterStatus.DEAD, "walter.jpg");
        when(characterService.updateStatusToDead(characterId)).thenReturn(updatedCharacter);

        mockMvc.perform(patch("/api/characters/{id}/status", characterId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("DEAD"));
    }

    @Test
    @DisplayName("Debe devolver 404 al actualizar un personaje inexistente")
    void shouldReturnNotFoundWhenUpdatingNonExistentCharacter() throws Exception {
        Long nonExistentId = 999L;
        when(characterService.updateStatusToDead(nonExistentId)).thenThrow(new CharacterNotFoundException("Character not found with id: " + nonExistentId));

        mockMvc.perform(patch("/api/characters/{id}/status", nonExistentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Debe devolver 400 al crear un personaje con datos inválidos")
    void shouldReturnBadRequestWhenCreateCharacterWithInvalidData() throws Exception {
        CreateCharacterDTO invalidDTO = new CreateCharacterDTO("", "", null, null, "");

        mockMvc.perform(post("/api/characters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidDTO)))
                .andExpect(status().isBadRequest());
    }
}
