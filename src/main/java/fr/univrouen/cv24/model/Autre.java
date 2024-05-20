package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "autre")
@XmlType(propOrder = {"titre", "comment"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Autre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "titre", required = true)
    private String titre;

    @XmlAttribute(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "divers_id", nullable = false)
    @XmlTransient
    private Divers divers;

    public Autre(String titre, String comment, Divers divers) {
        this.titre = titre;
        this.comment = comment;
        this.divers = divers;
    }

    public Autre() {}

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    @Override
    public String toString() {
        return "Autre {" +
               "id=" + id +
               ", titre='" + titre + '\'' +
               ", comment='" + comment + '\'' +
               "}";
    }
}
