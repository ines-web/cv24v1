package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.Identite;

import fr.univrouen.cv24.repository.IdentityRepository;
@Service
public class identiteService {
	  @Autowired
	    private IdentityRepository identiteRepository;

	    /**
	     * Enregistre une identité dans la base de données.
	     *
	     * @param identite L'identité à enregistrer.
	     * @param id L'ID du CV associé à cette identité.
	     * @return L'identité enregistrée.
	     */
	    public Identite saveIdentite(Identite identite) {
	       
	        return identiteRepository.save(identite);
	    }

}
