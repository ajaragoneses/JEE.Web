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
	
    @OneToMany(cascade = CascadeType.ALL)
    private List<Voto> listaVotos;
	
	public Tema() {
	}
	

	public Tema(String pregunta, String nombreTema) {
		super();
		this.pregunta = pregunta;
		this.nombreTema = nombreTema;
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
   
}
