package es.ajaragoneses.votacion.models.daos.JPA;

import es.ajaragoneses.votacion.models.daos.VotoDao;
import es.ajaragoneses.votacion.models.entities.Voto;

public class VotoDaoJPA extends GenericDaoJPA<Voto, Integer> implements VotoDao {

	public VotoDaoJPA() {
		super(Voto.class);
	}
}
