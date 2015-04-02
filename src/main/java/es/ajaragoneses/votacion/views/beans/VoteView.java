package es.ajaragoneses.votacion.views.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.ajaragoneses.votacion.models.daos.DaoFactory;
import es.ajaragoneses.votacion.models.daos.TemaDao;
import es.ajaragoneses.votacion.models.daos.JPA.DaoJPAFactory;
import es.ajaragoneses.votacion.models.entities.Tema;
import es.ajaragoneses.votacion.models.entities.Voto;
import es.ajaragoneses.votacion.models.utils.NivelEstudios;

@ManagedBean
@ViewScoped
public class VoteView implements Serializable {
	private static final long serialVersionUID = 1L;
	private int voto = -1;
	private int[] listaVotos;
	private String pregunta = "";
    private List<String> listaPreguntas;
    private String Ip = "";
	private TemaDao temaDao;
	private List<String> listaTemasString;
	private NivelEstudios nivelEstudios = null;
	private boolean temaElegido = false;
	private String Tema = "";
	private List<String> listaTemas;
	private NivelEstudios[] listaNivelEstudios;	
	private Logger log = LogManager.getLogger(VoteView.class);
	
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<String> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(List<String> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public String getTema() {
		return Tema;
	}

	public void setTema(String tema) {
		temaElegido = true;
		preparePreguntasList();
		Tema = tema;
	}

	private void preparePreguntasList() {
		List<Tema> listaObjetosTema = temaDao.findAll();
		log.info(listaObjetosTema.size());
		listaPreguntas = new ArrayList<String>();
		
		assert(listaObjetosTema.size() == 0);
		
		for (int i = 0; i < listaObjetosTema.size(); i++) {
			if(listaObjetosTema.get(i).getNombreTema().equals(Tema)){
				log.info(listaObjetosTema.get(i).getPregunta());
				listaPreguntas.add(listaObjetosTema.get(i).getPregunta());
			}
        }
		
	}

	public List<String> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<String> listaTemas) {
		this.listaTemas = listaTemas;
	}

	
	
	public boolean isTemaElegido() {
		return temaElegido;
	}

	public void setTemaElegido(boolean temaElegido) {
		this.temaElegido = temaElegido;
	}


    
    
	public VoteView(){
		DaoFactory.setFactory(new DaoJPAFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		
		List<Tema> listaObjetosTema = temaDao.findAll();
		log.info(listaObjetosTema.size());
		listaTemasString = new ArrayList<String>();
		
		assert(listaObjetosTema.size() == 0);
		
		for (int i = 0; i < listaObjetosTema.size(); i++) {
			log.info(listaObjetosTema.get(i).getNombreTema());
			listaTemasString.add(listaObjetosTema.get(i).getNombreTema());
        }
		
		listaVotos = new int[10];
        for (int i = 0; i < listaVotos.length; i++) {
        	listaVotos[i] = i;
        }
        
        listaNivelEstudios = NivelEstudios.values();
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Ip = httpServletRequest.getRemoteAddr();
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

	public List<String> getlistaPreguntas() {
		return listaPreguntas;
	}

	public void setlistaPreguntas(List<String> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
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

	public String getpregunta() {
		return pregunta;
	}

	public void setpregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String process(){
		if(AllFieldsNotNUll()){
			log.info("Procesando...");
			Voto votoObject = new Voto(voto, Ip, nivelEstudios);
			
			List<Tema> listaObjetosTema = temaDao.findAll();
			log.info(listaObjetosTema.size());
			
			assert(listaObjetosTema.size() == 0);
			
			for (int i = 0; i < listaObjetosTema.size(); i++) {
				log.info(listaObjetosTema.get(i).getNombreTema());
				if(!listaObjetosTema.get(i).getNombreTema().equals(Tema)) continue;
				if(!listaObjetosTema.get(i).getPregunta().equals(pregunta)) continue;
				listaObjetosTema.get(i).getListaVotos().add(votoObject);
				temaDao.update(listaObjetosTema.get(i));
				break;
	        }
			
		}
		return null;
	}
	
	private boolean AllFieldsNotNUll() {
		if(voto < 0) return false;
		if(Tema.equals("")) return false;
		if(Ip.equals("")) return false;
		if(nivelEstudios == null) return false;
		if(pregunta.equals("")) return false;
		return true;
	}
}