package es.ajaragoneses.votacion.views.jsf;

import java.io.Serializable;

public class DeleteTemaView implements Serializable{

	private static final long serialVersionUID = 1L;
	private int code;
	private boolean autorizado = false;
	
	
	public DeleteTemaView(){
		
	}
	
	public String process(){
		if(code == 666){
			autorizado = true;
		}
		return null;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
}
