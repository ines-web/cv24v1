package fr.univrouen.cv24.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "competences")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"diplomes", "certifications"})
public class Competences implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @OneToMany(mappedBy = "competences", cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "diplôme", required = true)
    private List<Diplome> diplomes;
    

    @OneToMany(mappedBy = "competences", cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "certif")
    private List<Certif> certifications= new ArrayList<>();

    public Competences() {}

    public Long getId() {
        return id;
    }

    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    public List<Certif> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certif> certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "Competence {" +
               "id=" + id +
               ", diplomes=" + diplomes +
               ", certifications=" + certifications +
               "}";
    }
}
