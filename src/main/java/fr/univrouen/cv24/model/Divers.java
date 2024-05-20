package fr.univrouen.cv24.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "divers")
@XmlType(propOrder = {"lv", "autre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Divers implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @OneToMany(mappedBy = "divers", cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "lv", required = true)
    @BatchSize(size = 5)
    private List<LV> lv;

    @OneToMany(mappedBy = "divers", cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "autre")
    @BatchSize(size = 3)
    private List<Autre> autre;

    public Divers(List<LV> lv, List<Autre> autre) {
        this.lv = lv;
        this.autre = autre;
    }

    public Divers() {}

    public Long getId() {
        return id;
    }

    public List<LV> getLv() {
        return lv;
    }

    public void setLv(List<LV> lv) {
        this.lv = lv;
    }

    public List<Autre> getAutre() {
        return autre;
    }

    public void setAutre(List<Autre> autre) {
        this.autre = autre;
    }

    @Override
    public String toString() {
        return "Divers {" +
               "id=" + id +
               ", lv=" + lv +
               ", autre=" + autre +
               "}";
    }
}
