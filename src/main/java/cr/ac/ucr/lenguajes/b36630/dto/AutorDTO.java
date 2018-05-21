package cr.ac.ucr.lenguajes.b36630.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Autor")
public class AutorDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_autor")
	private int codAutor;
	
	@Column(name="nombre_autor")
	private String nombreAutor;
	
	@Column(name="apellidos_autor")
	private String apellidosAutor;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	mappedBy = "autores")
	@JsonIgnore
	private List<LibroDTO> libros;


	public AutorDTO() {
		super();
		this.codAutor = 0;
		this.nombreAutor = "";
		this.apellidosAutor = "";
		
	}

	public int getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(int codAutor) {
		this.codAutor = codAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidosAutor() {
		return apellidosAutor;
	}

	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}

	public List<LibroDTO> getLibros() {
		return this.libros;
	}

	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
	}
	
	
	
}
