package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUtilisateur;
    String prenom;
    String nom;
    String password;
    @ManyToOne
    @JsonIgnore
    Classe classe;

}
