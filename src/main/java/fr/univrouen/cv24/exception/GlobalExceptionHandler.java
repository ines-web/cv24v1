package fr.univrouen.cv24.exception;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@ControllerAdvice
public class GlobalExceptionHandler {

    private String convertToXml(ErrorResponse errorResponse) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(errorResponse, writer);
            return writer.toString();
        } catch (Exception e) {
              return "<Resultat><id>0</id><status>ERROR</status></Resultat>";
        }
    }
    
    
    @ExceptionHandler(CVNotFoundException.class)
    public ResponseEntity<String> handleCVNotFoundException(CVNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(0, "None ");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(convertToXml(error));
    }


    @ExceptionHandler(JAXBException.class)
    public ResponseEntity<String> handleJAXBException(JAXBException ex) {
    	
        ErrorResponse error = new ErrorResponse(0, "ERROR : INVALID_XML "+ ex.getMessage() );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                 .body(convertToXml(error));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        ErrorResponse error = new ErrorResponse(0, "ERROR :INVALID_FILE");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body(convertToXml(error));
    }
    
    
    @ExceptionHandler(SAXParseException.class)
    public ResponseEntity<String> handleSAXParseException(SAXParseException ex) {
        int lineNumber = ex.getLineNumber();
        int columnNumber = ex.getColumnNumber();
    
        ErrorResponse error = new ErrorResponse(0, "ERROR : INVALID_XML_SCHEMA line :"+lineNumber+" column :"+columnNumber );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                 .body(convertToXml(error));
    }


    @ExceptionHandler(SAXException.class)
    public ResponseEntity<String> handleSAXException(SAXException ex) {
    	
    	
        ErrorResponse error = new ErrorResponse(0, "ERROR : INVALID_XML_SCHEMA");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                 .body(convertToXml(error));
    }

    @ExceptionHandler(DuplicateCVException.class)
    public ResponseEntity<String> handleDuplicateCVException(DuplicateCVException ex) {
    	
        ErrorResponse error = new ErrorResponse(0, "ERROR : DUPLICATED");
        return ResponseEntity.status(HttpStatus.CONFLICT)
                 .body(convertToXml(error));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        ErrorResponse error = new ErrorResponse(0, "ERROR : INTERNAL_ERROR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body(convertToXml(error));
    }
}