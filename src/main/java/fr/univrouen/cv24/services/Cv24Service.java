package fr.univrouen.cv24.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.univrouen.cv24.exception.DuplicateCVException;
import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.Competences;
import fr.univrouen.cv24.model.Cv24Resume;
import fr.univrouen.cv24.model.Detail;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.LV;
import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.model.Titre;
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

	    @Transactional
	    public String saveCV(CV24 cv) {
	        try {
	            // Vérifiez si un CV similaire existe déjà
	            if (cv24Repository.existsByIdentiteNomAndIdentitePrenomAndIdentiteMel(
	                    cv.getIdentite().getNom(), cv.getIdentite().getPrenom(), cv.getIdentite().getMel())) {
	                throw new DuplicateCVException("Un CV avec la même identité existe déjà.");
	            }

	            // Sauvegarde de l'identité
	            identity.saveIdentite(cv.getIdentite());

	            // Sauvegarde de l'objectif
	            objectifService.saveObjectif(cv.getObjectif());

	            // Sauvegarde des informations professionnelles
	            Prof prof = cv.getProf();
	            if (prof != null) {
	                for (Detail detail : prof.getDetails()) {
	                    detail.setProf(prof);
	                }
	                profService.saveProf(prof);
	            }

	            // Sauvegarde des compétences
	            Competences competences = cv.getCompetence();
	            if (competences != null) {
	                for (Diplome diplome : competences.getDiplomes()) {
	                	
	                	  if (diplome != null) {
	                          for (Titre titre : diplome.getTitre()) {
	                              titre.setDiplome(diplome);
	                           }
	                      }
	                	
	                    diplome.setCompetence(competences);
	                }
	                for (Certif certif : competences.getCertifications()) {
	                    certif.setCompetence(competences);
	                }
	                competencesService.saveCompetences(competences);
	            }

	            // Sauvegarde des informations diverses
	            Divers divers = cv.getDivers();
	            if (divers != null) {
	                for (LV lv : divers.getLv()) {
	                    lv.setDivers(divers);
	                }
	                for (Autre autre : divers.getAutre()) {
	                    autre.setDivers(divers);
	                }
	                divService.saveDivers(divers);
	            }

	            // Sauvegarde finale du CV
	            cv24Repository.save(cv);
	        } catch (DuplicateCVException e) {
	            System.err.println("Erreur : " + e.getMessage());
	            return "Une erreur s'est produite lors de la sauvegarde du CV : " + e.getMessage()+"";
	            // Gérer l'exception pour les CV en double (ex. : retour d'une réponse HTTP appropriée dans un contexte web)
	        } catch (DataIntegrityViolationException e) {
	        	
	            System.err.println("Erreur d'intégrité des données : " + e.getMessage());
	            return "Erreur d'intégrité des données : " + e.getMessage()+"";
	            // Gérer l'exception liée à la violation de contraintes d'intégrité des données
	        } catch (Exception e) {
	            System.err.println("Une erreur s'est produite lors de la sauvegarde du CV : " + e.getMessage());
	            // Gérer toute autre exception
	            return "Une erreur s'est produite lors de la sauvegarde du CV : " + e.getMessage()+"";
	        }
	        return "cv est bien inseré";
	    }
	

	    public List<CV24> findAll() {
	        return cv24Repository.findAll();
	    }  
	
	

	    public CV24 getCVById(int id) {
	        return cv24Repository.findById(id);
	    }
	    
	    
	    public List<Cv24Resume> getAllCVResumes() {
	        List<CV24> cvs = cv24Repository.findAll();
	        return cvs.stream().map(cv -> {
	            Cv24Resume resume = new Cv24Resume();
	            resume.setId(cv.getId());
	            resume.setGenre(cv.getIdentite().getGenre());
	            resume.setNom(cv.getIdentite().getNom());
	            resume.setPrenom(cv.getIdentite().getPrenom());
	            resume.setObjectif(cv.getObjectif().getStatus() + " " + cv.getObjectif().getObjectif());
	            resume.setDiplome(cv.getCompetence().getDiplomes().stream().findFirst().orElse(null)); // Assuming the highest/recent diploma is the first
	            return resume;
	        }).collect(Collectors.toList());
	    }
	    
	    
	}
