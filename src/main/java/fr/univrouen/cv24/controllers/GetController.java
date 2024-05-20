package fr.univrouen.cv24.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.services.Cv24Service;
import fr.univrouen.cv24.util.Fichier;

@Controller
public class GetController {


	  @Autowired
	    private Cv24Service cv24Service;

	    @GetMapping("/cv24/resume")
	    public String listCVs(Model model) {
	        List<CV24> cvs = cv24Service.findAll();
	        model.addAttribute("cvs", cvs);
	        return "cvlist";
	    }
    @GetMapping("/cvid")
    public String getCVinXML(@RequestParam(value = "texte") String texte) {
        return "Détail du CV n°" + texte;
    }
    
    
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	
	@RequestMapping("/*")
	public String notFound() {
		return "notFound";
	}


    @GetMapping("/test")
    public String getTestXML(@RequestParam(value = "id") int id, @RequestParam(value = "titre") String titre) {
        return "Test: \n id= " + id + "\n titre= " + titre;
    }

    @Autowired
    private Fichier fichier;

    @GetMapping("/testfic")
    public String afficherContenuFichier() {
        return fichier.loadFileXML();
    }

   
}
