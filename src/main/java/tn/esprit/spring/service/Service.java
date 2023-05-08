package tn.esprit.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Classe;
import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.utilisateur;
import tn.esprit.spring.repository.utilisateurRepository;
import tn.esprit.spring.repository.ClasseRepository;
import tn.esprit.spring.repository.CoursClassroomRepository;

import tn.esprit.spring.serviceInterface.Iservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
@Slf4j
public class Service implements Iservice {
    @Autowired
    utilisateurRepository utilisateurRepository;
    @Autowired
ClasseRepository classeRepository;
    @Autowired
    CoursClassroomRepository coursClassroomRepository;

    public utilisateur ajouterUtilisateur (utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }
    public Classe ajouterClasse (Classe c)
    {
        classeRepository.save(c);
        return c;
    }
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer idClasse)
    {  Classe classe= classeRepository.findById(idClasse).get();
        cc.setClasse(classe);
        coursClassroomRepository.save(cc);
        return cc;
    }

    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer idClasse)
    {
        Classe classe= classeRepository.findById(idClasse).get();
        utilisateur utilisateur= utilisateurRepository.findById(idUtilisateur).get();
        utilisateur.setClasse(classe);
        utilisateurRepository.save(utilisateur);

    }
    @Override
    public Classe retrieveClasse(Integer id) {
        Classe c= classeRepository.findById(id).get();
        return c;
    }

    @Override
    public Classe AjouterClasseEtAffecterCoursClasse(Classe c, Integer idCours) {
        CoursClassroom cc= coursClassroomRepository.findById(idCours).get();

        Set<CoursClassroom> ccs = new HashSet<CoursClassroom>();
        ccs.add(cc);
        c.setCoursClassrooms(ccs);

        return classeRepository.save(c);

    }
    @Override
    public void deleteClasse(Integer id) {
        classeRepository.deleteById(id);

    }

    @Override
    public Classe updateClasse(Classe c) {
        classeRepository.save(c);
        return c;
    }
    @Override
    public List<Classe> retrieveAllClasses() {
        List<Classe> listClasse= classeRepository.findAll();
        for(Classe c:listClasse)
        {
            log.info("Classe:" + c.getTitre()+ " " + c.getNiveau() + " " + c.getCodeClass());
        }
        return listClasse;
    }

    public Integer nbUtilisateursParNiveau(Niveau nv)
    {
        return utilisateurRepository.nbUtilisateurParNiveau(nv);
    }
}
