package fr.univrouen.cv24.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "cv24")
@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@XmlType(namespace = "http://univ.fr/cv24",propOrder={"identite", "objectif", "prof", "competences", "divers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24 implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identite_id", referencedColumnName = "id")
    @XmlElement(name="identite" , namespace = "http://univ.fr/cv24" ,required = true)
    private Identite identite;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objectif_id", referencedColumnName = "id")
    @XmlElement(name="objectif" , namespace = "http://univ.fr/cv24",required = true)
    private Objectif objectif;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prof_id", referencedColumnName = "id")
    @XmlElement(name="prof", namespace = "http://univ.fr/cv24")
    private Prof prof;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competences_id", referencedColumnName = "id")
    @XmlElement(name ="competences", namespace = "http://univ.fr/cv24",required = true)
    private Competences competences;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "divers_id", referencedColumnName = "id")
    @XmlElement(name="divers", namespace = "http://univ.fr/cv24" )
    private Divers divers;

    public CV24(Identite identite, Objectif objectif, Prof prof,Competences competences, Divers divers) {
        this.identite = identite;
        this.objectif = objectif;
        this.prof = prof;
        this.competences = competences;
        this.divers = divers;
    }

    public CV24() {}

    public Long getId() {
        return id;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof ) {
        this.prof = prof;
    }

    public Competences getCompetence() {
        return competences;
    }

    public void setCompetence(Competences competences) {
        this.competences = competences;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    @Override
    public String toString() {
        return "CV24 {" +
                "id=" + id +
                ", identite=" + identite +
                ", objectif=" + objectif +
                ", prof=" + prof +
                ", competence=" + competences +
                ", divers=" + divers +
                '}';
    }
}
