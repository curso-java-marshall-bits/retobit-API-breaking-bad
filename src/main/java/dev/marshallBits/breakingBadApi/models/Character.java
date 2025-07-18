package dev.marshallBits.breakingBadApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CharacterStatus status;

    @ElementCollection
    @CollectionTable(name = "character_seasons", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "season")
    private List<Integer> seasons;

    private String imageUrl;
}
