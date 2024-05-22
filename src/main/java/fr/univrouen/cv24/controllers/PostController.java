package fr.univrouen.cv24.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xml.sax.SAXException;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.services.Cv24Service;
import fr.univrouen.cv24.xmlValidation.xmlConvert;
import jakarta.xml.bind.JAXBException;

@Controller
public class PostController {
    @Autowired
    private Cv24Service cv24Service;

    @PostMapping(value = "/cv24/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> insertCV(@RequestBody String flux) throws JAXBException, IOException, SAXException {
        xmlConvert transform = new xmlConvert();
        CV24 cv = transform.ConvertXmlToCv(flux);
        cv24Service.saveCV(cv);
        // Créer un message de succès ou un objet de réponse XML approprié
        String successMessage = "<Resultat><id>"+cv.getId()+"</id></Resultat><status>SUCCESS</status></Resultat>";
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(successMessage);
    }
}