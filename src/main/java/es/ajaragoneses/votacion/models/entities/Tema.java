package es.ajaragoneses.votacion.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tema
 *
 */
@Entity
public class Tema implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;

	private String pregunta;	
	
	private String nombreTema;
	
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Voto> listaVotos;
	
	public Tema() {
	}
	

	public Tema(String pregunta, String nombreTema) {
		super();
		this.pregunta = pregunta;
		this.nombreTema = nombreTema;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public List<Voto> getListaVotos() {
		return listaVotos;
	}


	public void setListaVotos(List<Voto> listaVotos) {
		this.listaVotos = listaVotos;
	}
	
	@Override
	public String toString() {
		return "Tema [id=" + id + ", pregunta=" + pregunta + ", nombreTema="
				+ nombreTema + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((listaVotos == null) ? 0 : listaVotos.hashCode());
		result = prime * result
				+ ((nombreTema == null) ? 0 : nombreTema.hashCode());
		result = prime * result
				+ ((pregunta == null) ? 0 : pregunta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaVotos == null) {
			if (other.listaVotos != null)
				return false;
		} else if (!listaVotos.equals(other.listaVotos))
			return false;
		if (nombreTema == null) {
			if (other.nombreTema != null)
				return false;
		} else if (!nombreTema.equals(other.nombreTema))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		return true;
	}
   
}
