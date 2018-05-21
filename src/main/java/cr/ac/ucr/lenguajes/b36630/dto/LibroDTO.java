package cr.ac.ucr.lenguajes.b36630.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Libro")
public class LibroDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_libro")
	private int numLibro;
	
	@Column(name="titulo_libro")
	private String tituloLibro;
	
	@Column(name="ano_publicacion")
	private int anoPublicacion;
	
	@Column(name="isbn")
	private String isbn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cod_publicador")
	@JsonIgnore
    private PublicadorDTO publicador;
	
	@Column(name="precio")
	private float precio;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="Libro_Autor",
	joinColumns = {@JoinColumn(name="num_libro")},
	inverseJoinColumns = {@JoinColumn(name="cod_autor")})
	private List<AutorDTO> autores;
	
	public LibroDTO() {
		super();
		this.numLibro = 0;
		this.tituloLibro = "";
		this.anoPublicacion = 0;
		this.isbn = "";
		this.publicador = new PublicadorDTO();
		this.precio = 0;
		this.autores = new ArrayList<AutorDTO>();
	}

	public int getNumLibro() {
		return numLibro;
	}

	public void setNumLibro(int numLibro) {
		this.numLibro = numLibro;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public int getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(int anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public PublicadorDTO getPublicador() {
		return publicador;
	}

	public void setPublicador(PublicadorDTO publicador) {
		this.publicador = publicador;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<AutorDTO> getAutores() {
		return this.autores;
	}

	public void setAutores(List<AutorDTO> autores) {
		this.autores = autores;
	}
	
}
