package fr.univrouen.cv24.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "lv")
@XmlType(propOrder = {"lang", "cert", "nivs", "nivi"})
@XmlAccessorType(XmlAccessType.FIELD)
public class LV implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "lang", required = true)
    private String lang;

    @XmlAttribute(name = "cert", required = true)
    private String cert;

    @XmlAttribute(name = "nivs")
    private String nivs;

    @XmlAttribute(name = "nivi")
    private String nivi;

    @ManyToOne
    @JoinColumn(name = "divers_id", nullable = false)
    @XmlTransient
    private Divers divers;

    public LV(String lang, String cert, String nivs, String nivi, Divers divers) {
        this.lang = lang;
        this.cert = cert;
        this.nivs = nivs;
        this.nivi = nivi;
        this.divers = divers;
    }

    public LV() {}

    public Long getId() {
        return id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getNivs() {
        return nivs;
    }

    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    public String getNivi() {
        return nivi;
    }

    public void setNivi(String nivi) {
        this.nivi = nivi;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    @Override
    public String toString() {
        return "LV {" +
               "id=" + id +
               ", lang='" + lang + '\'' +
               ", cert='" + cert + '\'' +
               ", nivs='" + nivs + '\'' +
               ", nivi='" + nivi + '\'' +
               "}";
    }
}
