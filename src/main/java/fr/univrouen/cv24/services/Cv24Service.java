package fr.univrouen.cv24.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.Competences;
import fr.univrouen.cv24.model.Detail;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.LV;
import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.repository.CV24Repository;

@Service
public class Cv24Service {
	 @Autowired
	    private CV24Repository cv24Repository;
		@Autowired
		private identiteService identity ;
	    @Autowired
	    private DiversService divService;
	    @Autowired
	    private CompetencesService competencesService;
	    @Autowired
	    private ProfService profService;
	    @Autowired
	    private ObjectifService objectifService;

	    public void saveCV(CV24 cv) {
	    	 identity.saveIdentite(cv.getIdentite());
			 objectifService.saveObjectif(cv.getObjectif());
	            Prof prof = cv.getProf();
		        if (prof != null) {
		            for (Detail detail : prof.getDetails()) {
		            	detail.setProf(prof);
		            }	         
		            profService.saveProf(prof);           
		        }
		        Competences competences = cv.getCompetence();
		        if (competences != null) {
		            for (Diplome diplome : competences.getDiplomes()) {
		                diplome.setCompetence(competences);
		            }
		            for (Certif certif : competences.getCertifications()) {
		                certif.setCompetence(competences);
		            }
		            competencesService.saveCompetences(competences);} 
	        Divers divers  = cv.getDivers();
	        if (divers != null) {
	            for (LV lv : divers.getLv()) {
	            	lv.setDivers(divers);
	            }
	         
	            for (Autre autre : divers.getAutre()) {
	            	autre.setDivers(divers);
	                } 
	            divService.saveDivers(divers);
	        cv24Repository.save(cv);
	    }

	}
	

	    public List<CV24> findAll() {
	        return cv24Repository.findAll();
	    }  
	
	
	
	}
