package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "detail")
@XmlType(propOrder = {"datedeb", "datefin", "titre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @Column(name = "datedeb")
    @XmlElement(name = "datedeb", required = true)
    private String datedeb;

    @Column(name = "datefin", nullable = true)
    @XmlElement(name = "datefin", required = true)
    private String datefin;

    @Column(name = "titre", length = 128)
    @XmlElement(name = "titre", required = true)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "prof_id", nullable = false)
    @XmlTransient
    private Prof prof;

    public Detail(String datedeb, String datefin, String titre, Prof prof) {
        super();
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.titre = titre;
        this.prof = prof;
    }

    public Detail() {
    }

    public Long getId() {
        return this.id;
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

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        return "Detail {" + 
               "id=" + id + 
               ", datedeb=" + datedeb + 
               ", datefin=" + datefin + 
               ", titre=" + titre + 
               "}";
    }
}
