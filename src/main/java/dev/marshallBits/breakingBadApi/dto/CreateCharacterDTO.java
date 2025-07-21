package dev.marshallBits.breakingBadApi.dto;

import dev.marshallBits.breakingBadApi.models.CharacterStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterDTO {

    // TODO: Agregar las validaciones apropiadas
    // Usar @NotBlank para campos de texto obligatorios
    // Usar @NotNull para campos obligatorios
    // Usar @Size para limitar longitud de texto

    private String name;

    private String occupation;

    private CharacterStatus status;

    private String imageUrl;
}
