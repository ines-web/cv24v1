package fr.univrouen.cv24.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.exception.ErrorResponse;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.Cv24Resume;
import fr.univrouen.cv24.model.Cv24ResumeList;
import fr.univrouen.cv24.services.Cv24Service;
import fr.univrouen.cv24.util.Fichier;
import fr.univrouen.cv24.xmlValidation.xmlConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBException;

@Controller
public class GetController {


	  @Autowired
	    private Cv24Service cv24Service;
	//recuperer la liste des cv en HTML
	    @GetMapping("/cv24/resume")
	    public String listCVs(Model model) {
	       
	        List<Cv24Resume> cvs = cv24Service.getAllCVResumes();
	        model.addAttribute("cvs", cvs);
	        return "cvlist";
	    }
 
    
	    @GetMapping(value = "/cv24/xml", produces = MediaType.APPLICATION_XML_VALUE)
	    public ResponseEntity<String> getCVById(@RequestParam("id") int id) throws JAXBException {
	        CV24 cv = cv24Service.getCVById(id); // Cette méthode lance une exception si le CV n'est pas trouvé
	        xmlConvert convert = new xmlConvert();
	        String xml = convert.convertCVtoXML(cv);
	        return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(xml);
	    }

    
    
    @GetMapping("/cv24/html")
    public String getCVCompletHTMLByID(@RequestParam("id") int cvId, Model model){
        CV24 cv = cv24Service.getCVById(cvId);
        model.addAttribute("cv24", cv);
        return "cv24";
    }
    
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	


	@GetMapping(value = "/cv24/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	 @ResponseBody
    public Cv24ResumeList getAllCVResumes() {
        List<Cv24Resume> resumes = cv24Service.getAllCVResumes();
        return new Cv24ResumeList(resumes);
    }

	
	@GetMapping(value = "/cv24/search", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Cv24ResumeList searchCVs(
        @RequestParam(value = "date", required = false) String date,
        @RequestParam(value = "objectif", required = false) String objectif) {

        System.out.println("hey********************************************************************* " + date + objectif);

        List<CV24> cvs = cv24Service.searchCVs(date, objectif);
        return new Cv24ResumeList(cvs.stream().map(cv -> {
            Cv24Resume resume = new Cv24Resume();
            resume.setId(cv.getId());
            resume.setGenre(cv.getIdentite().getGenre());
            resume.setNom(cv.getIdentite().getNom());
            resume.setPrenom(cv.getIdentite().getPrenom());
            resume.setObjectif(cv.getObjectif());

            // Récupérez le diplôme avec la date spécifiée
            resume.setDiplome(cv.getCompetence().getDiplomes().stream()
                .filter(diplome -> date == null || diplome.getDate().equals(date))
                .findFirst().orElse(null));
            
            return resume;
        }).collect(Collectors.toList()));
    }

   
}
