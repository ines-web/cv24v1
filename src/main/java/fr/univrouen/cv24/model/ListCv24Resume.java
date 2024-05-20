package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "listcv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCv24Resume implements Serializable {

    
    @XmlElement(name = "cv24Resume")
    private List<ListCv24Resume> listCv24Resumes;

   
    public List<ListCv24Resume> getCvResumeList() {
        return listCv24Resumes;
    }

  
    public void setCvResumeList(List<ListCv24Resume> cv24) {
        this.listCv24Resumes = cv24;
    }
}

