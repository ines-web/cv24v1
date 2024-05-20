package fr.univrouen.cv24.model;



import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;


import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "objectif")
@XmlType(name = "objectif")
@XmlAccessorType(XmlAccessType.FIELD)
public class Objectif implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @Column(name = "objectif", length = 128)
    @XmlElement(name="objectif")
    private String objectif;
    
    @XmlAttribute(name = "status")
    private String status;

    public Objectif() {
        // Constructeur par défaut pour JPA
    }

	public Objectif(String status) {
		super();
		this.status 	= status;
	}
	

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Objectif [id=" + id + ", status=" + status + "]";
    }
}

	
