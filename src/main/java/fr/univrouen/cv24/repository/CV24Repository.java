package fr.univrouen.cv24.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.univrouen.cv24.model.CV24;

@Repository

public interface CV24Repository extends JpaRepository<CV24, Long> {
	 boolean existsByIdentiteNomAndIdentitePrenomAndIdentiteMel(String nom, String prenom, String mel);

	 Optional<CV24> findById(int id);

	void deleteById(int id);

	boolean existsById(int id);

	

    
}