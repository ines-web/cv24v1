package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "diplome") 
@XmlType(propOrder = {"niveau", "date", "institut", "titre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplome implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @Column(name = "niveau", nullable = false)
    @XmlAttribute(name ="niveau", required = true)
    private int niveau;

    @Column(name = "date", nullable = false)
    @XmlElement(required = true)
    private String date;

    @Column(name = "institut")
    @XmlElement
    private String institut;

    @Column(name = "titre", nullable = false, length = 32)
    @XmlElement(required = true)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "competence_id", nullable = false)
    @XmlTransient
    private Competences competences;

    public Diplome(int niveau, String date, String institut, String titre, Competences competences) {
        this.niveau = niveau;
        this.date = date;
        this.institut = institut;
        this.titre = titre;
        this.competences = competences;
    }

    public Diplome() {}

    public Long getId() {
        return id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
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
        return "Diplome {" +
                "id=" + id +
                ", niveau=" + niveau +
                ", date=" + date +
                ", institut='" + institut + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
