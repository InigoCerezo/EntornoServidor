package daw2.dwes.morty2.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "locations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name", nullable = false, length = 255)
    private String name;

    @Column(name = "location_type", length = 255)
    private String type;

    @Column(name = "dimension_name", length = 255)
    private String dimension;

    // TODO: Añadir la relación para los personajes
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters;

}


