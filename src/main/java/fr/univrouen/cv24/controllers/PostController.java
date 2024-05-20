package fr.univrouen.cv24.controllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xml.sax.SAXException;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.Competences;
import fr.univrouen.cv24.model.Detail;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.LV;
import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.services.CompetencesService;
import fr.univrouen.cv24.services.Cv24Service;
import fr.univrouen.cv24.services.DiversService;
import fr.univrouen.cv24.services.ObjectifService;
import fr.univrouen.cv24.services.ProfService;
import fr.univrouen.cv24.services.identiteService;
import fr.univrouen.cv24.xmlValidation.xmlConvert;
import jakarta.xml.bind.JAXBException;

@Controller
public class PostController {
    @Autowired
    private Cv24Service cv24Service;

    @PostMapping(value = "/cv24/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> postTest(@RequestBody String flux) {
        xmlConvert transform = new xmlConvert();
        CV24 cv;
        try {
            cv = transform.ConvertXmlToCv(flux);
        } catch (JAXBException | IOException | SAXException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing XML");
        }

		
             cv24Service.saveCV(cv);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_XML)
                    .body("INSERTED");
       
    }

	
}
