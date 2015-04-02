package es.ajaragoneses.votacion.views.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;


@ManagedBean
@ViewScoped
public class DeleteTemaView implements Serializable{

	private static final long serialVersionUID = 1L;
	private int code;
	private boolean autorizado = false;
	private boolean mostrarMensajeError = false;
	private int temaId = -1;
	private List<Tema> listaTemas;
	private TemaDao temaDao;
	private boolean mostrarMensajeBorrado;
	private Logger log = LogManager.getLogger(DeleteTemaView.class);

	
	
	public DeleteTemaView(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		listaTemas = temaDao.findAll();
		log.info(listaTemas.size());
	}
	
	public String process(){
		mostrarMensajeError = false;
		mostrarMensajeBorrado = false;
		if(autorizar() && !autorizado){
			autorizado = true;
			log.info("Autorizando...");
			return null;
		}
		if(AllFieldsNotNUll()){
			temaDao.deleteById(temaId);
			log.info("procesando borrado del id: " + temaId);
			mostrarMensajeBorrado = true;
		} else {
			mostrarMensajeError = true;
		}
		return null;
	}

	private boolean AllFieldsNotNUll() {
		log.info(temaId);
		if(code != 666) return false;
		log.info("code == 666");
		if(temaId == -1) return false;
		log.info("temaId: " + temaId);
		return true;
	}

	private boolean autorizar() {
		if(code != 666) return false;
		return true;
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

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}

	public boolean isMostrarMensajeError() {
		return mostrarMensajeError;
	}

	public void setMostrarMensajeError(boolean mostrarMensajeError) {
		this.mostrarMensajeError = mostrarMensajeError;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public boolean isMostrarMensajeBorrado() {
		return mostrarMensajeBorrado;
	}

	public void setMostrarMensajeBorrado(boolean mostrarMensajeBorrado) {
		this.mostrarMensajeBorrado = mostrarMensajeBorrado;
	}
}
