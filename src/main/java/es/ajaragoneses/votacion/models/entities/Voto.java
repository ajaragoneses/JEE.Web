package es.ajaragoneses.votacion.models.entities;

import es.ajaragoneses.votacion.models.utils.NivelEstudios;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Voto
 * 
 */
@Entity
public class Voto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	private Integer Valor;
	
	private String IP;
	
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;
	
	

	public Voto(Integer valor, String iP, NivelEstudios nivelEstudios) {
		super();
		Valor = valor;
		IP = iP;
		this.nivelEstudios = nivelEstudios;
	}


	public Voto() {
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValor() {
		return Valor;
	}

	public void setValor(Integer valor) {
		Valor = valor;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}


	@Override
	public String toString() {
		return "Voto [id=" + id + 
						", Valor=" + Valor + 
						", IP=" + IP + 
						", NivelEstudios="+this.nivelEstudios.name()+"]";
	}

   
}
