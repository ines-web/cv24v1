package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Titre" dans le modèle CV.
 */

@XmlType(name = "titre")
@Entity
@Table(name = "titre")
@XmlAccessorType(XmlAccessType.FIELD)
public class Titre{

    /**
     * L'identifiant unique du titre.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    /**
     * Le titre lui-même.
     */
    @Column(name = "titre", nullable = false)
    @XmlValue
    private String titre;

    /**
     * L'identifiant du diplôme auquel ce titre est associé.
     */

    
    
    @ManyToOne
    @JoinColumn(name = "diplome_id", nullable = false)
    @XmlTransient
    private Diplome diplome;

    // Getters et setters

    /**
     * Obtient l'identifiant unique du titre.
     *
     * @return L'identifiant du titre.
     */
    public long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du titre.
     *
     * @param id Le nouvel identifiant du titre.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtient le titre.
     *
     * @return Le titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre.
     *
     * @param titre Le nouveau titre.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }


     
    public Diplome getDiplome() {
        return diplome;
    }

    /**
     * Définit l'identifiant du diplôme associé à ce titre.
     *
     * @param id Le nouvel identifiant du diplôme.
     */
    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
}
