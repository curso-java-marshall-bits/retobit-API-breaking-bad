package dev.marshallBits.breakingBadApi.dto;

import dev.marshallBits.breakingBadApi.models.CharacterStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {

    private Long id;
    private String name;
    private String occupation;
    private CharacterStatus status;
    private List<Integer> seasons;
    private String imageUrl;
}
