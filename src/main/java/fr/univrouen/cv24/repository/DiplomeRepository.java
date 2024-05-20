package fr.univrouen.cv24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univrouen.cv24.model.Diplome;
@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

}
