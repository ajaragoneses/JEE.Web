package es.ajaragoneses.votacion.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/jsp/*")
public class dispatcher extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Logger log = LogManager.getLogger(dispatcher.class);


    @Override
    public void init() throws ServletException {
        log.info("poipoipoi");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	log.info("Hola mundo!");
    	 String web = "<html><head><title>Dispatcher</title></head>"
                 + "<body> <h1>Despachando cositas...</h1>" + "</body></html>";
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         out.println(web);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
}
