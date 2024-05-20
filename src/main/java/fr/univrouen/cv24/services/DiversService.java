package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.repository.DiversRepository;


@Service
public class DiversService {
	   @Autowired
	    private DiversRepository diversRepository;

	    public void saveDivers(Divers divers) {
	    	
	    	diversRepository.save(divers);
	    }
}
