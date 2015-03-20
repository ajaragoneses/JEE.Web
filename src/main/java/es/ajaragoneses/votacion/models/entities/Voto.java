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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IP == null) ? 0 : IP.hashCode());
		result = prime * result + ((Valor == null) ? 0 : Valor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nivelEstudios == null) ? 0 : nivelEstudios.hashCode());
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
		Voto other = (Voto) obj;
		if (IP == null) {
			if (other.IP != null)
				return false;
		} else if (!IP.equals(other.IP))
			return false;
		if (Valor == null) {
			if (other.Valor != null)
				return false;
		} else if (!Valor.equals(other.Valor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nivelEstudios != other.nivelEstudios)
			return false;
		return true;
	}

   
}
