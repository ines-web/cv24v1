package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Competences;
import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.repository.CompetencesRepository;
import fr.univrouen.cv24.repository.CertifRepository;
import fr.univrouen.cv24.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetencesService {


    @Autowired
    private CompetencesRepository competencesRepository;

    public void saveCompetences(Competences competences) {
        competencesRepository.save(competences);
    }
}