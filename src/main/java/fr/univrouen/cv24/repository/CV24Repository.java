package fr.univrouen.cv24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.univrouen.cv24.model.CV24;

@Repository

public interface CV24Repository extends JpaRepository<CV24, Long> {

    
}