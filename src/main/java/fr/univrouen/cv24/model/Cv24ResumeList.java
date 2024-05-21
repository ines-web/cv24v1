package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Cette classe représente une liste de résumés de CV.
 */
@XmlRootElement(name = "cv24Resumes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cv24ResumeList {

    @XmlElement(name = "cv24Resume")
    private List<Cv24Resume> cv24Resumes;

    public Cv24ResumeList() {}

    public Cv24ResumeList(List<Cv24Resume> cv24Resumes) {
        this.cv24Resumes = cv24Resumes;
    }

    public List<Cv24Resume> getCv24Resumes() {
        return cv24Resumes;
    }

    public void setCv24Resumes(List<Cv24Resume> cv24Resumes) {
        this.cv24Resumes = cv24Resumes;
    }
}
