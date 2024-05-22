package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.univrouen.cv24.exception.ErrorResponse;
import fr.univrouen.cv24.services.Cv24Service;


@Controller
public class DeleteController {
    @Autowired
    private Cv24Service cv24Service;

    @DeleteMapping(value = "/cv24/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> deleteCV(@RequestParam("id") int cvId) {
        cv24Service.deleteCVById(cvId); // Suppose que cette méthode lève une exception si le CV n'est pas trouvé
        String successMessage = "<Resultat> <id>"+cvId+"</id><status>SUCCESS:Votre CV a été bien supprimé.</status></Resultat>";
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(successMessage);
    }
}