package com.mnuenninghoff.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Searches database for all NPCs created by a user, sends the returned list to
 */
@WebServlet(
        name="viewNPC",
        urlPatterns = {"/viewNPC"}
)
public class ViewNPC extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Handles Http Get requests
     *
     * @param request               HttpServletRequest
     * @param response              HttpServletResponse
     * @throws ServletException     Servlet Exception
     * @throws IOException          IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
    }
}

