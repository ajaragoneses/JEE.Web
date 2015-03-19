package es.ajaragoneses.votaciones.models.daos.JPA;

import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.entities.Tema;

public class TemaDaoJPA extends GenericDaoJPA<Tema, Integer> implements TemaDao {

	
	public TemaDaoJPA() {
		super(Tema.class);
	}
}
