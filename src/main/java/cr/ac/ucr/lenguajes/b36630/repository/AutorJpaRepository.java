package cr.ac.ucr.lenguajes.b36630.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cr.ac.ucr.lenguajes.b36630.dto.AutorDTO;;

public interface AutorJpaRepository extends JpaRepository<AutorDTO, Integer>{
	List<AutorDTO> findAll();
}
