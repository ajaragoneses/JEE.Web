package es.ajaragoneses.votacion.views.beans;

import java.io.Serializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;



public class AddTemaView implements Serializable{

	private static final long serialVersionUID = 1L;
	private TemaDao temaDao;
	private String NombreTema = "";
	private String Pregunta = "";
	
	private Logger log = LogManager.getLogger(AddTemaView.class);

	public AddTemaView(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}
	
	public String process(){
		if(notNullFields()){
			Tema t = new Tema(Pregunta, NombreTema);
			temaDao.create(t);
			log.info("Tema creado con exito");
		}
		return null;
	}

	public String getNombreTema() {
		return NombreTema;
	}

	public void setNombreTema(String nombreTema) {
		NombreTema = nombreTema;
	}

	public String getPregunta() {
		return Pregunta;
	}

	public void setPregunta(String pregunta) {
		Pregunta = pregunta;
	}

	private boolean notNullFields() {
		log.info(NombreTema);
		log.info(Pregunta);
		if(NombreTema.equals("")) return false;
		if(Pregunta.equals("")) return false;
		log.info("todo true!!!");
		return true;
	}
}
