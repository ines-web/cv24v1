package fr.univrouen.cv24.xmlValidation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

public class XMLValidator {

    public void validateXMLWithXSD(String xmlContent, String xsdFilePath) throws IOException, SAXException {
        Resource resourceXSD = new ClassPathResource(xsdFilePath);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(resourceXSD.getInputStream());
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        StringReader reader = new StringReader(xmlContent);
        Source source = new StreamSource(reader);
        validator.validate(source);
    }
}