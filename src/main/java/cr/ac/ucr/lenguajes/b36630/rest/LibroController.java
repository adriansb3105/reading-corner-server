package cr.ac.ucr.lenguajes.b36630.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.lenguajes.b36630.repository.AutorJpaRepository;
//import cr.ac.ucr.lenguajes.b36630.repository.CustomRepository;
import cr.ac.ucr.lenguajes.b36630.repository.LibroJpaRepository;
import cr.ac.ucr.lenguajes.b36630.repository.PublicadorJpaRepository;
import cr.ac.ucr.lenguajes.b36630.dto.AutorDTO;
import cr.ac.ucr.lenguajes.b36630.dto.Generic;
//import cr.ac.ucr.lenguajes.b36630.dto.CustomDTO;
import cr.ac.ucr.lenguajes.b36630.dto.LibroDTO;
import cr.ac.ucr.lenguajes.b36630.dto.PublicadorDTO;

@RestController
@RequestMapping("/api/")
public class LibroController {
	
	@Autowired
	private LibroJpaRepository libroJpaRepository;

	@Autowired
	private PublicadorJpaRepository publicadorJpaRepository;

	@Autowired
	private AutorJpaRepository autorJpaRepository;

	//@Autowired
	//private CustomRepository customRepository;

	@Autowired
	public void setJpaRepository(LibroJpaRepository libroJpaRepository, PublicadorJpaRepository publicadorJpaRepository, AutorJpaRepository autorJpaRepository){
		this.libroJpaRepository = libroJpaRepository;
		this.publicadorJpaRepository = publicadorJpaRepository;
		this.autorJpaRepository = autorJpaRepository;
	//	this.customRepository = customRepository;
	}
	
	@GetMapping("/libros")
	public ResponseEntity<List<LibroDTO>> listAllLibros(){
		List<LibroDTO> libros = libroJpaRepository.findAll();
		return new ResponseEntity<List<LibroDTO>>(libros, HttpStatus.OK);
	}

	@GetMapping("/publicadores")
	public ResponseEntity<List<PublicadorDTO>> listAllPublicadores(){
		List<PublicadorDTO> publicadores = publicadorJpaRepository.findAll();
		return new ResponseEntity<List<PublicadorDTO>>(publicadores, HttpStatus.OK);
	}

	@GetMapping("/autores")
	public ResponseEntity<List<AutorDTO>> listAllAutores(){
		List<AutorDTO> autores = autorJpaRepository.findAll();
		return new ResponseEntity<List<AutorDTO>>(autores, HttpStatus.OK);
	}

	@GetMapping("buscar/{libro}/{publicador}")
	public ResponseEntity<List<Generic>> findByLibroPublicador(@PathVariable("libro") final String libro, @PathVariable("publicador") final String publicador) {
		List<LibroDTO> libros = libroJpaRepository.findByLibroPublicador(libro, publicador);
		List<Generic> generics = new ArrayList<Generic>();

		for(int i=0; i<libros.size(); i++){
			Generic generic = new Generic();
			generic.setNumLibro(libros.get(i).getNumLibro());
			generic.setTituloLibro(libros.get(i).getTituloLibro());
			generic.setAnoPublicacion(libros.get(i).getAnoPublicacion());
			generic.setNombrePublicador(libros.get(i).getPublicador().getNombrePublicador());
			generics.add(generic);
		}

		return new ResponseEntity<List<Generic>>(generics, HttpStatus.OK);
	}
	
	//@PostMapping(value = "/search", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<List<LibroDTO>> searchBooks(){
		//ResponseEntity<List<Coincidencia>> //@RequestBody final String libro
		//List<PublicadorDTO> publicadores = publicadorJpaRepository.findAll();
	//	List<LibroDTO> libros = libroJpaRepository.findAll();
		//List<Coincidencia> coincidencias = new ArrayList<>();
		
		/*for(int i=0; i<publicadores.size(); i++){
			for(int j=0; j<libros.size(); j++){
				if(publicadores.get(i).getCodPublicador().equals(libros.get(j).getCodPublicador())){
					String codigo = String.valueOf(libros.get(j).getNumLibro()); 
					String titulo = libros.get(j).getTituloLibro();
					String ano = String.valueOf(libros.get(j).getAnoPublicacion());
					String nombrePublicador = publicadores.get(i).getNombrePublicador();
					
					coincidencias.add(new Coincidencia(codigo, titulo, ano, nombrePublicador));
				}
			}
		}*/
		
	//	return new ResponseEntity<List<LibroDTO>>(libros, HttpStatus.CREATED);
	//}
	

	/*
	@PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDTO> createUser(@RequestBody final LibroDTO libro){
		libroJpaRepository.save(libro);
		return new ResponseEntity<LibroDTO>(libro, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LibroDTO> getUserById(@PathVariable("id") final Long id){
		LibroDTO libro = libroJpaRepository.findById(id).get();
		return new ResponseEntity<LibroDTO>(libro, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LibroDTO> deleteUser(@PathVariable("id") final Long id){
		libroJpaRepository.deleteById(id);
		return new ResponseEntity<LibroDTO>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDTO> updateUser(@PathVariable("id") final Long id, @RequestBody LibroDTO libro){
		LibroDTO currentLibro = libroJpaRepository.findById(id).get();
		//currentUser.setFirstname(user.getFirstname());
		currentLibro.setTituloLibro(libro.getTituloLibro());
		currentLibro.setAnoPublicacion(libro.getAnoPublicacion());
		currentLibro.setIsbn(libro.getIsbn());
		currentLibro.setCodPublicador(libro.getCodPublicador());
		currentLibro.setPrecio(libro.getPrecio());		
		
		libroJpaRepository.saveAndFlush(currentLibro);
		
		return new ResponseEntity<LibroDTO>(currentLibro, HttpStatus.OK);
	}
	*/
}
