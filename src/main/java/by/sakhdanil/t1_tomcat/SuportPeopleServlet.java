package by.sakhdanil.t1_tomcat;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "supportServlet", value = "/help-service/v1/support")
public class SuportPeopleServlet extends HttpServlet {

    private MangerRep mangerRep;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mangerRep = new MangerRep();
    }

    public SuportPeopleServlet(MangerRep mangerRep) {
        this.mangerRep = mangerRep;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("plain/text");
        response.getWriter().append(mangerRep.getPhrase());

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("plain/text");
        response.getWriter().append(mangerRep.addPhrase(request.getParameter("Phrase")));
    }

}
