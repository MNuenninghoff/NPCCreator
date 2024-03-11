package com.mnuenninghoff.controller;

import com.mnuenninghoff.entity.*;
import com.mnuenninghoff.persistence.GenericDao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        NPC npc = null;

        // Check what submit button was clicked, call appropriate method
        String submit = request.getParameter("submit");
        logger.debug("submit value: " + submit);
        if (submit.equals("generateNPC")) {
            npc = generateNewNPC();
        }

        // TODO: remove after done with debugging
        session.setAttribute("test", "went through GenerateActionServlet");
        // Add npc to the session
        logger.debug(npc);
        session.setAttribute("newNPC", npc);
        // forward to editNPC.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("editNPC.jsp");
        dispatcher.forward(request, response);
    }

    private NPC generateNewNPC() {
        NPC npc = new NPC();
        Random random = new Random();
        // add random value for...
        // Ability
        GenericDao<Ability> abilityDao = new GenericDao<>(Ability.class);
        List<Ability> abilities = abilityDao.getAll();
        Ability randomAbility = abilities.get(random.nextInt(abilities.size()));
        npc.setAbility(randomAbility);
        // Appearance
        GenericDao<Appearance> appearanceDao = new GenericDao<>(Appearance.class);
        List<Appearance> appearances = appearanceDao.getAll();
        Appearance randomAppearance = appearances.get(random.nextInt(appearances.size()));
        npc.setAppearance(randomAppearance);
        // Bond
        GenericDao<Bond> bondDao = new GenericDao<>(Bond.class);
        List<Bond> bonds = bondDao.getAll();
        Bond randomBond = bonds.get(random.nextInt(bonds.size()));
        npc.setBond(randomBond);
        // InteractionTraits
        GenericDao<InteractionTraits> interactionTraitsDao = new GenericDao<>(InteractionTraits.class);
        List<InteractionTraits> interactionTraits = interactionTraitsDao.getAll();
        InteractionTraits randomInteractionTraits = interactionTraits.get(random.nextInt(interactionTraits.size()));
        npc.setInteractionTraits(randomInteractionTraits);
        // Mannerisms

        // Race

        // Name

        // Talent

        // User TODO: set user value equal to the userid in session

        return npc;
    }
}
