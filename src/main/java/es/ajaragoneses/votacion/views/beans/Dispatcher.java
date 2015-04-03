package es.ajaragoneses.votacion.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.ajaragoneses.votacion.models.utils.NivelEstudios;


@WebServlet("/votacion/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/votacionJSP/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);
        System.out.println("doGet");
        String view;
        switch (action) {
        case "vote":
            VoteView voteView = new VoteView();
            voteView.setIp(request.getRemoteAddr());
            request.setAttribute(action, voteView);
            view = action;
            break;
        case "listVote":
        	ListVoteView listVoteView = new ListVoteView();
        	request.setAttribute(action, listVoteView);
        	view = action;
            break;
        case "addTema":
        	AddTemaView addTemaView = new AddTemaView();
        	request.setAttribute(action, addTemaView);
        	view = action;
        	break;
        case "deleteTema":
        	DeleteTemaView deleteTemaView = new DeleteTemaView();
        	request.setAttribute(action, deleteTemaView);
        	view = action;
        	break;	
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("doPost");
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "vote":
        	VoteView voto = new VoteView();
        	System.out.println(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
        	voto.setIp(request.getRemoteAddr());
        	voto.setNivelEstudios(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
        	voto.setVoto(Integer.parseInt(request.getParameter("voto")));
        	voto.process(Integer.parseInt(request.getParameter("pregunta")));
            break;
        case "listaVotos":
            break;
        case "addTema":
        	System.out.println("<addTema>");
        	AddTemaView addTemaView = new AddTemaView();
        	addTemaView.setNombreTema(request.getParameter("temaName"));
        	addTemaView.setPregunta(request.getParameter("pregunta"));
        	addTemaView.process();
        	break;
        case "deleteTema":
        	DeleteTemaView deleteTemaView = new DeleteTemaView();
        	deleteTemaView.setCode(Integer.parseInt(request.getParameter("code")));
        	deleteTemaView.setTemaId(Integer.parseInt(request.getParameter("tema")));
        	deleteTemaView.process();
        	request.setAttribute(action, deleteTemaView);
        	view = action;
        	break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
