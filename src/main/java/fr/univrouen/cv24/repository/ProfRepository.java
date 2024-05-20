package fr.univrouen.cv24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.univrouen.cv24.model.Prof;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Long>{

}
