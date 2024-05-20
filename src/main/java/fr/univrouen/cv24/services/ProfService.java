package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.repository.ProfRepository;

@Service
public class ProfService {
	   @Autowired
	    private ProfRepository profRepository;

	    public void saveProf(Prof Prof) {
	    	
	    	profRepository.save(Prof);
	    }
}
