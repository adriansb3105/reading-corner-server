package cr.ac.ucr.lenguajes.b36630.dto;

public class Generic {

    private int numLibro;
    private String tituloLibro;
    private int anoPublicacion;
    private String nombrePublicador;
    
    public Generic() {
		super();
        this.numLibro = 0;
        this.tituloLibro = "";
        this.anoPublicacion = 0;
        this.nombrePublicador = "";
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

    public String getNombrePublicador() {
		return nombrePublicador;
	}

	public void setNombrePublicador(String nombrePublicador) {
		this.nombrePublicador = nombrePublicador;
    }
}