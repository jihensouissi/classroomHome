package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.utilisateur;

public interface utilisateurRepository  extends JpaRepository<utilisateur, Integer> {

    @Query("select count (utilisateur ) from utilisateur u where u.classe.niveau= :niveau ")
    Integer nbUtilisateurParNiveau(@Param("niveau") Niveau niveau);
}
