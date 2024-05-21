package fr.univrouen.cv24.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.cv24.model.Titre;

public interface TitreRepository extends JpaRepository<Titre, Long> {

}
