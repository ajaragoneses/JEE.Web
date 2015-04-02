package es.ajaragoneses.votacion.views.beans;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/votacionJSP/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/votacionJSP/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
//        case "":
//        	view = "";
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
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
//        case "":
//            break;
        default:
        	break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
	
