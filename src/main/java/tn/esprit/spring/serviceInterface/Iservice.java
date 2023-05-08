package tn.esprit.spring.serviceInterface;

import tn.esprit.spring.entities.Classe;
import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.utilisateur;

import java.util.List;

public interface Iservice {
    public utilisateur ajouterUtilisateur (utilisateur utilisateur);
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer idClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer idClasse);

    List<Classe> retrieveAllClasses();


    Classe retrieveClasse(Integer classeId);

    Classe AjouterClasseEtAffecterCoursClasse(Classe c, Integer coursClassroomId);

    Classe updateClasse(Classe classe);

    void deleteClasse(Integer classeId);
    public Integer nbUtilisateursParNiveau(Niveau nv);
}
