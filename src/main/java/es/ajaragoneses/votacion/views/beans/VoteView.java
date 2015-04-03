package es.ajaragoneses.votacion.views.beans;

import java.io.Serializable;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;
import es.ajaragoneses.votacion.models.entities.Voto;
import es.ajaragoneses.votacion.models.utils.NivelEstudios;


public class VoteView implements Serializable {
	private static final long serialVersionUID = 1L;
	private int voto = -1;
	private int[] listaVotos;
    private List<Tema> listaTemasObj;
    private String Ip = "";
	private TemaDao temaDao;
	private List<String> listaTemasString;
	private NivelEstudios nivelEstudios = null;
	private NivelEstudios[] listaNivelEstudios;	
	private Logger log = LogManager.getLogger(VoteView.class);
	
	

	public VoteView(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		
		listaTemasObj = temaDao.findAll();
		log.info(listaTemasObj.size());
		
		assert(listaTemasObj.size() == 0);
		
		listaVotos = new int[11];
        for (int i = 0; i < listaVotos.length; i++) {
        	listaVotos[i] = i;
        }
        
        listaNivelEstudios = NivelEstudios.values();
        
     	}
	
	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public int[] getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(int[] listaVotos) {
		this.listaVotos = listaVotos;
	}


	public TemaDao getTemaDao() {
		return temaDao;
	}

	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public NivelEstudios[] getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(NivelEstudios[] listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}


	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public int[] getlistaVotos() {
		return listaVotos;
	}

	public void setlistaVotos(int[] listaVotos) {
		this.listaVotos = listaVotos;
	}

	public List<String> getListaTemasString() {
		return listaTemasString;
	}

	public void setListaTemasString(List<String> listaTemas) {
		this.listaTemasString = listaTemas;
	}

	public int getvoto() {
		return voto;
	}

	public void setvoto(int voto) {
		this.voto = voto;
	}

	
	public String process(int temaId){
		if(AllFieldsNotNUll()){
			log.info("Procesando...");
			Voto votoObject = new Voto(voto, Ip, nivelEstudios);
			
			Tema tema = temaDao.read(temaId);
			tema.getListaVotos().add(votoObject);
			temaDao.update(tema);
			
			List<Tema> listaObjetosTema = temaDao.findAll();
			log.info(listaObjetosTema.size());
			
		}
		return null;
	}
	
	private boolean AllFieldsNotNUll() {
		if(voto < 0) return false;
		if(Ip.equals("")) return false;
		if(nivelEstudios == null) return false;
		return true;
	}

	public List<Tema> getListaTemasObj() {
		return listaTemasObj;
	}

	public void setListaTemasObj(List<Tema> listaTemasObj) {
		this.listaTemasObj = listaTemasObj;
	}
}