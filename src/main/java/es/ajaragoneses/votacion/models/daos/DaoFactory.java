package es.ajaragoneses.votacion.models.daos;

import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.VotoDao;

public abstract class DaoFactory {

	public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract TemaDao getTemaDao();

    public abstract VotoDao getVotoDao();

	
}
