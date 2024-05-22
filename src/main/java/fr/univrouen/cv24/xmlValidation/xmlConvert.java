package fr.univrouen.cv24.xmlValidation;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.xml.sax.SAXException;
import fr.univrouen.cv24.model.CV24;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class xmlConvert {
    public CV24 ConvertXmlToCv(String xmlContent) throws JAXBException, IOException, SAXException {
        XMLValidator validator = new XMLValidator();
        validator.validateXMLWithXSD(xmlContent, "cv24.tp1.xsd");
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlContent);
        return (CV24) unmarshaller.unmarshal(reader);
    }
    
    public String convertCVtoXML(CV24 cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        return writer.toString().replaceAll("ns2:", "cv24:");
    }
}