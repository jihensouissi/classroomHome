package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoursClassroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCours;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    Integer nbHeurs;
    String nom;
    boolean archive;
    @JsonIgnore
    @ManyToOne
    private Classe classe;
}
