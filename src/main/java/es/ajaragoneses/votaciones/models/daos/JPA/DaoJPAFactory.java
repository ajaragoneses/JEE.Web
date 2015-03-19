package es.ajaragoneses.votaciones.models.daos.JPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.VotoDao;

public class DaoJPAFactory extends DaoFactory{
    private static final String PERSISTENCE_UNIT = "SistemaVotacion";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJPAFactory() {
        LogManager.getLogger(DaoJPAFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public TemaDao getTemaDao() {
		return new TemaDaoJPA();
	}

	@Override
	public VotoDao getVotoDao() {
		return new VotoDaoJPA();
	}

}