package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "certif")
@XmlType(propOrder = {"datedeb", "datefin", "titre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Certif implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @Column(name = "datedeb", nullable = false)
    @XmlElement(required = true)
    private String datedeb;

    @Column(name = "datefin")
    @XmlElement
    private String datefin;

    @Column(name = "titre", nullable = false, length = 32)
    @XmlElement(required = true)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "competence_id", nullable = false)
    @XmlTransient // Vous pouvez retirer cette annotation si nécessaire
    private Competences competences;


    public Certif(String datedeb, String datefin, String titre, Competences competences) {
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.titre = titre;
        this.competences = competences;
    }

    public Certif() {}

    public Long getId() {
        return id;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Competences getCompetence() {
        return competences;
    }

    public void setCompetence(Competences competence) {
        this.competences = competence;
    }

    @Override
    public String toString() {
        return "Certif {" +
                "id=" + id +
                ", datedeb=" + datedeb +
                ", datefin=" + datefin +
                ", titre='" + titre + '\'' +
                '}';
    }
}
