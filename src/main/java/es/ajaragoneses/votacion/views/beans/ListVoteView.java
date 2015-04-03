package es.ajaragoneses.votacion.views.beans;

import java.io.Serializable;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;

public class ListVoteView implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(ListVoteView.class);
	private TemaDao temaDao;
	private List<Tema> listaTemas;
	
	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}
	
	public ListVoteView(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		listaTemas = temaDao.findAll();
		log.info(listaTemas.size());
	}
	
}
