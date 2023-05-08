package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codeClass;
    String titre;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @JsonIgnore
    @OneToMany(mappedBy="classe")
    private Set<CoursClassroom> coursClassrooms;
}
