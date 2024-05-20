package fr.univrouen.cv24.xmlValidation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

@Component
public class XMLValidator {

    public  boolean validateXMLWithXSD(String xmlContent, String xsdFilePath) throws IOException, SAXException {
        Resource resourceXSD = new ClassPathResource(xsdFilePath);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(resourceXSD.getInputStream());
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        StringReader reader = new StringReader(xmlContent);
        Source source = new StreamSource(reader);

        // Validez la source XML par rapport au schéma XSD
        validator.validate(source);
        return true;
    }
    public static void main(String[] args) {
        XMLValidator validator = new XMLValidator();
        try {
            // Load XML content
            String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                    + "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.tp1.xsd \">\r\n"
                    + "  <cv24:identite>\r\n"
                    + "    <genre>M</genre>\r\n"
                    + "    <nom>N</nom>\r\n"
                    + "    <prenom>prenom</prenom>\r\n"
                    + "    <tel>+33 1 23 45 67 89</tel>\r\n"
                    + "    <mel>mel@hs.fr</mel>\r\n"
                    + "  </cv24:identite>\r\n"
                    + "  <cv24:objectif status=\"stage\"/>\r\n"
                    + "  <cv24:prof>\r\n"
                    + "    <detail>\r\n"
                    + "      <datedeb>2001-01-01</datedeb>\r\n"
                    + "      <datefin>2001-01-01</datefin>\r\n"
                    + "      <titre>titre</titre>\r\n"
                    + "    </detail>\r\n"
                    + "    \r\n"
                    + "  </cv24:prof>\r\n"
                    + "  <cv24:competences>\r\n"
                    + "    <diplôme niveau=\"1\">\r\n"
                    + "      <date>2001-01-01</date>\r\n"
                    + "      <institut>institut</institut>\r\n"
                    + "      <titre>titre</titre>\r\n"
                    + "      \r\n"
                    + "    </diplôme>\r\n"
                    + "    \r\n"
                    + "    \r\n"
                    + "    <certif>\r\n"
                    + "      <datedeb>2001-01-01</datedeb>\r\n"
                    + "      <datefin>2001-01-01</datefin>\r\n"
                    + "      <titre>titre</titre>\r\n"
                    + "      \r\n"
                    + "    </certif>\r\n"
                    + "    \r\n"
                    + "    \r\n"
                    + "    \r\n"
                    + "  </cv24:competences>\r\n"
                    + "  \r\n"
                    + "  <cv24:divers>\r\n"
                    + "    <lv cert=\"MAT\" lang=\"\"/>\r\n"
                    + "    \r\n"
                    + "    <autre titre=\"ss\"/>\r\n"
                    + "  </cv24:divers>\r\n"
                    + "</cv24:cv24>\r\n"
                    + "";

            // Path to the XSD file in the resources directory
            String xsdFilePath = "cv24.tp1.xsd";

            // Validate XML against XSD
            boolean isValid = validator.validateXMLWithXSD(xmlContent, xsdFilePath);
            if (isValid) {
                System.out.println("XML is valid.");
            } else {
                System.out.println("XML is not valid.");
            }
        } catch (IOException | SAXException e) {
            System.err.println("Error during XML validation: " + e.getMessage());
        }
    }
}
