package cr.ac.ucr.lenguajes.b36630.dto;

import javax.persistence.CascadeType;

 import java.util.ArrayList;
 import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Publicador")
public class PublicadorDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_publicador")
	private int codPublicador;
	
	@Column(name="nombre_publicador")
	private String nombrePublicador;
	
	@Column(name="url_sitio_web")
	private String urlSitioWeb;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToMany(mappedBy = "publicador", cascade = CascadeType.ALL)
	private List<LibroDTO> libros;

	public PublicadorDTO() {
		super();
		this.codPublicador = 0;
		this.nombrePublicador = "";
		this.urlSitioWeb = "";
		this.telefono = "";
		this.libros = new ArrayList<LibroDTO>();
	}

	public int getCodPublicador() {
		return codPublicador;
	}

	public void setCodPublicador(int codPublicador) {
		this.codPublicador = codPublicador;
	}

	public String getNombrePublicador() {
		return nombrePublicador;
	}

	public void setNombrePublicador(String nombrePublicador) {
		this.nombrePublicador = nombrePublicador;
	}

	public String getUrlSitioWeb() {
		return urlSitioWeb;
	}

	public void setUrlSitioWeb(String urlSitioWeb) {
		this.urlSitioWeb = urlSitioWeb;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
	}

	public List<LibroDTO> getLibros(){
		return this.libros;
	}
	
}
