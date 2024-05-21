package fr.univrouen.cv24.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<?> getCVById(@RequestParam("id") int id) {
        try {
            CV24 optionalCV = cv24Service.getCVById(id);
      
            if (optionalCV != null) {
                xmlConvert convert = new xmlConvert(); 
                String xml =convert.convertCVtoXML(optionalCV);
                return new ResponseEntity<>(xml, HttpStatus.OK);
            } else {
                ErrorResponse errorResponse = new ErrorResponse(id, "ERROR");
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(id, "ERROR");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
	
	@RequestMapping("/*")
	public String notFound() {
		return "notFound";
	}
//recuperer la liste des cv en xml
	@GetMapping(value = "/cv24/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	 @ResponseBody
    public Cv24ResumeList getAllCVResumes() {
        List<Cv24Resume> resumes = cv24Service.getAllCVResumes();
        return new Cv24ResumeList(resumes);
    }

    @Autowired
    private Fichier fichier;

    @GetMapping("/testfic")
    public String afficherContenuFichier() {
        return fichier.loadFileXML();
    }

   
}
