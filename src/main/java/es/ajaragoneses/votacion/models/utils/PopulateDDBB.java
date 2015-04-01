package es.ajaragoneses.votacion.models.utils;

import java.util.ArrayList;
import java.util.List;

import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;
import es.ajaragoneses.votacion.models.entities.Voto;

public class PopulateDDBB {

	public static void main(String args[]){
		DaoFactory.setFactory(new DaoJPAFactory());
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema t = new Tema("¿Es esto un test?","PREGUNTA_TEST");
		temaDao.create(t);
	}
}
