package models.daos.JPA;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.VotoDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;
import es.ajaragoneses.votacion.models.entities.Voto;
import es.ajaragoneses.votacion.models.utils.NivelEstudios;


public class TemaJPAtest {

	private static TemaDao temaDao;
	private static VotoDao votoDao;
	private static Tema t;
	private static Voto v1, v2;
	
	@Before
	public void init(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
		t = new Tema("¿Es esto un test?","PREGUNTA_TEST");
		List<Voto> l = new ArrayList<Voto>();
		v1 = new Voto(10, "127.0.0.1", NivelEstudios.BACHILLERATO);
		v2 = new Voto(1, "127.0.0.9", NivelEstudios.BASICO);
		l.add(v1);
		l.add(v2);
		t.setListaVotos(l);
		temaDao.create(t);
	}
	
	@Test
	public void readTest() {
		Tema temaLeido = temaDao.read(t.getId());
		assertEquals(t, temaLeido);
	}
	
	@Test
	public void deleteTest() {
		List<Voto>laux = t.getListaVotos();
		laux.remove(v1);
		temaDao.update(t);
		Tema temaLeido = temaDao.read(t.getId());
		assertEquals(t.getListaVotos().size(), temaLeido.getListaVotos().size());
	}
	
	@Test
	public void updateTest() {
		List<Voto>laux = t.getListaVotos();
		laux.add(new Voto(5, "192.168.0.1", NivelEstudios.BASICO));
		temaDao.update(t);
		Tema temaLeido = temaDao.read(t.getId());
		assertEquals(t.getListaVotos().size(), temaLeido.getListaVotos().size());
	}

}
