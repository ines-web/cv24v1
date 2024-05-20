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
        // Valider le XML contre le schéma XSD
    	XMLValidator validator = new XMLValidator();
    	validator.validateXMLWithXSD(xmlContent, "cv24.tp1.xsd");
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlContent);
        // Désérialiser le XML en un objet Java
        return (CV24) unmarshaller.unmarshal(reader);
    }
    
    
    public String convertCVtoXML(CV24 cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        String  xml = writer.toString().replaceAll("ns2", "cv24");
        xml = xml.toString().replaceAll("<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\">", "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.tp1.xsd\">");
        return xml;
    }
    
    
    public static void main(String[] args) throws JAXBException, IOException, SAXException {
                 // Load XML content
    		xmlConvert convert = new xmlConvert();
            String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            		+ "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.tp1.xsd \">\r\n"
            		+ "  <cv24:identite>\r\n"
            		+ "    <genre>M.</genre>\r\n"
            		+ "    <nom>N</nom>\r\n"
            		+ "    <prenom>prenom</prenom>\r\n"
            		+ "    <tel>+33 1 23 45 67 89</tel>\r\n"
            		+ "    <mel>mel@hs.fr</mel>\r\n"
            		+ "  </cv24:identite>\r\n"
            		+ "  <cv24:objectif status=\"stage\"/>\r\n"
            		+ "  <cv24:competences>\r\n"
            		+ "    <diplôme niveau=\"1\">\r\n"
            		+ "      <date>2001-01-01</date>\r\n"
            		+ "      <institut>institut</institut>\r\n"
            		+ "      <titre>titre</titre>\r\n"
            		+ "\r\n"
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
            		+ "    <lv cert=\"MAT\" lang=\"fr\"/>\r\n"
            		+ "    \r\n"
            		+ "    <autre titre=\"ss\" comment=\"tets\"/>\r\n"
            		+ "  </cv24:divers>\r\n"
            		+ "</cv24:cv24>\r\n"
            		+ "";

            // Path to the XSD file in the resources directory
           CV24 cv24= convert.ConvertXmlToCv(xmlContent);
           System.out.println(cv24);
           
           String xml=convert.convertCVtoXML(cv24);
           System.out.println(xml);
           
         
           
       
    }

}


