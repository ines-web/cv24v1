package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "identite")
@XmlType(namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @Column(name = "genre", nullable = false)
    @XmlElement(required = true)
    private String genre;

    @Column(name = "nom", nullable = false, length = 32)
    @XmlElement(required = true)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 32)
    @XmlElement(required = true)
    private String prenom;

    @Column(name = "tel")
    @XmlElement
    private String tel;

    @Column(name = "mel")
    @XmlElement
    private String mel;

    public Identite(String genre, String nom, String prenom, String tel, String mel) {
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mel = mel;
    }

    public Identite() {}

    public Long getId() {
        return id;
    }
    

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNom(CV24 cv) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMel() {
        return mel;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }

    @Override
    public String toString() {
        return "Identite {" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mel='" + mel + '\'' +
                '}';
    }
}
