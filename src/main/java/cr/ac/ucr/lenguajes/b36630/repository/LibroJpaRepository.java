package cr.ac.ucr.lenguajes.b36630.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cr.ac.ucr.lenguajes.b36630.dto.LibroDTO;

public interface LibroJpaRepository extends JpaRepository<LibroDTO, Integer>{
	List<LibroDTO> findAll();

	@Query(value = "sp_findByLibroPublicador ?1, ?2", nativeQuery = true)
	List<LibroDTO> findByLibroPublicador(String tituloLibro, String nombrePublicador);
}
