package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}