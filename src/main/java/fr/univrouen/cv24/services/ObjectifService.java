package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.Objectif;
import fr.univrouen.cv24.repository.ObjectifRepository;
@Service
public class ObjectifService {
    @Autowired
    private ObjectifRepository objectifRepository;
    public Objectif saveObjectif(Objectif objectif){
       
        return objectifRepository.save(objectif);
    }

}
