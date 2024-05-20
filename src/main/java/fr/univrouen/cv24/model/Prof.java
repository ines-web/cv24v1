package fr.univrouen.cv24.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "prof")
@XmlType(propOrder = {"details"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Prof implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "detail", required = true)
    private List<Detail> details;
   
   
    public Prof(List<Detail> details) {
        super();
        this.details = details;
    }

    public Prof() {
    }

    public Long getId() {
        return this.id;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Prof {" + 
               "id=" + id + 
               ", details=" + details + 
               "}";
    }
}
