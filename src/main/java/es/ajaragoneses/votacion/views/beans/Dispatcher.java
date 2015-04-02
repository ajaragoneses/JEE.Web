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
//        case "rol":
//            RolView rolView = new RolView();
//            request.setAttribute(action, rolView);
//            view = action;
//            break;
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
//            Persona persona = new Persona();
//            persona.setId(Integer.valueOf(request.getParameter("id")));
//            persona.setNombre(request.getParameter("nombre"));
//            persona.setRol(request.getParameter("rol"));
//            PersonaView personaView = new PersonaView();
//            personaView.setPersona(persona);
//            request.setAttribute(action, personaView);
//            view = personaView.process();
            break;
//        case "rol":
//            RolView rolView = new RolView();
//            rolView.setRol(request.getParameter("rol"));
//            request.setAttribute(action, rolView);
//            view = rolView.process();
//            break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
