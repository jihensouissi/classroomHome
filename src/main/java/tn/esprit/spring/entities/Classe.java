package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
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
