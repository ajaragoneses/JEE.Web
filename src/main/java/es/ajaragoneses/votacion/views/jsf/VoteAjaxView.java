package es.ajaragoneses.votacion.views.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.ajaragoneses.votacion.models.entities.Tema;

@ManagedBean(name="voteAjaxView")
@ViewScoped
public class VoteAjaxView implements Serializable {
	private static final long serialVersionUID = 1L;

    private int TemaId;

    private List<Tema> Temas;

    private String question;

    private int[] votes;

    private boolean disabledVote;

    private int voteValue;

    private Logger log = LogManager.getLogger(VoteAjaxView.class);
    
    @PostConstruct
    public void update() {
    	log.info("Se actualizan datos de la capa de negocio...");
        Temas = new ArrayList<>();
        Temas.add(new Tema("Elige", ""));
        for (int i = 1; i < 6; i++) {
            Temas.add(new Tema("name" + i, "question" + i));
        }
        TemaId = 0;
        votes = new int[10];
        for (int i = 0; i < votes.length; i++) {
            votes[i] = i;
        }
        this.updateVote();
    }

    private void updateVote() {
    	log.info("updateVote()");
        question = Temas.get(TemaId).getPregunta();
        voteValue = votes[0];
        disabledVote = TemaId == 0;
    }

    public void setTemaId(int TemaId) {
        this.TemaId = TemaId;
        this.updateVote();
    }

    public String processVote() {
        log.info("Se accede a la capa de negocio --->>> TemaId: " + TemaId
                + "; voteValue: " + voteValue);
        return null;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getTemaId() {
        return TemaId;
    }

    public List<Tema> getTemas() {
        return Temas;
    }

    public String getQuestion() {
        return question;
    }

    public int[] getVotes() {
        return votes;
    }

    public boolean isDisabledVote() {
        return disabledVote;
    }

}