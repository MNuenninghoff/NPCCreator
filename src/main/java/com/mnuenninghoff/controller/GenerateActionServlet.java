package com.mnuenninghoff.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Generates random NPC
 */
@WebServlet(
        name="generateActionServlet",
        urlPatterns = {"/generateNPC"}
)
public class GenerateActionServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Handles HTTP Post requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Check what submit button was clicked, call appropriate method
        String submit = request.getParameter("submit");
        logger.debug("submit value: " + submit);

        // TODO: remove after done with debugging
        session.setAttribute("test", "went through GenerateActionServlet");
        // forward to editNPC.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("editNPC.jsp");
        dispatcher.forward(request, response);
    }
}
