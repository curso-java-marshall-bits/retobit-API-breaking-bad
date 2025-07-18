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
    // PISTA: Usar @NotBlank para campos de texto obligatorios
    // PISTA: Usar @NotNull para campos obligatorios
    // PISTA: Usar @Size para limitar longitud de texto

    private String name;

    private String occupation;

    private CharacterStatus status;

    private List<Integer> seasons;

    private String imageUrl;

    // EJEMPLO de cómo debería verse una vez completado:
    /*
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String name;

    @NotBlank(message = "La ocupación es obligatoria")
    @Size(max = 200, message = "La ocupación no puede exceder 200 caracteres")
    private String occupation;

    @NotNull(message = "El estado es obligatorio")
    private CharacterStatus status;

    // Las temporadas pueden ser opcionales
    private List<Integer> seasons;

    // La URL de imagen puede ser opcional
    private String imageUrl;
    */
}
