package com.mnuenninghoff.controller;

import com.mnuenninghoff.entity.*;
import com.mnuenninghoff.persistence.GenericDao;
import com.mnuenninghoff.persistence.IronArachneDao;
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
            npc = generateNewNPC(session);
            // TODO: remove after done with debugging
            // Add npc to the session
            logger.debug(npc);
            session.setAttribute("npc", npc);
            // forward to editNPC.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("editNPC.jsp");
            dispatcher.forward(request, response);
        } else if (submit.equals("saveNPC")) {
            saveNPC(session);
            //TODO: redirect to viewNPC
        } else if (submit.equals("deleteNPC")) {
            deleteNPC(session);
            //TODO: redirect to home
        }

    }

    /**
     * Generates a new random NPC
     * @param session   HttpSession
     * @return  randomly generated NPC
     */
    private NPC generateNewNPC(HttpSession session) {
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
        // Flaw
        GenericDao<Flaw> flawDao = new GenericDao<>(Flaw.class);
        List<Flaw> flaws = flawDao.getAll();
        Flaw randomFlaw = flaws.get(random.nextInt(flaws.size()));
        npc.setFlaw(randomFlaw);
        // InteractionTraits
        GenericDao<InteractionTraits> interactionTraitsDao = new GenericDao<>(InteractionTraits.class);
        List<InteractionTraits> interactionTraits = interactionTraitsDao.getAll();
        InteractionTraits randomInteractionTraits = interactionTraits.get(random.nextInt(interactionTraits.size()));
        npc.setInteractionTraits(randomInteractionTraits);
        // Mannerisms
        GenericDao<Mannerisms> mannerismsDao = new GenericDao<>(Mannerisms.class);
        List<Mannerisms> mannerisms = mannerismsDao.getAll();
        Mannerisms randomMannerism = mannerisms.get(random.nextInt(mannerisms.size()));
        npc.setMannerisms(randomMannerism);
        // Race
        GenericDao<Race> raceDao = new GenericDao<>(Race.class);
        List<Race> races = raceDao.getAll();
        Race randomRace = races.get(random.nextInt(races.size()));
        npc.setRace(randomRace);
        // Name
        IronArachneDao nameGenerator = new IronArachneDao();
        Name firstName = null;
        // randomly pick male/female first name
        if (random.nextInt(2) == 0) {
            firstName = nameGenerator.getMaleFirstName(randomRace.getRace());
        } else {
            firstName = nameGenerator.getFemaleFirstName(randomRace.getRace());
        }
        Name lastName = nameGenerator.getFamilyName(randomRace.getRace());
        String fullName = firstName.getNames().get(0) + " " + lastName.getNames().get(0);
        npc.setName(fullName);
        // Talent
        GenericDao<Talent> talentDao = new GenericDao<>(Talent.class);
        List<Talent> talents = talentDao.getAll();
        Talent randomTalent = talents.get(random.nextInt(talents.size()));
        npc.setTalent(randomTalent);
        // User
        if (session.getAttribute("user") != null) {
            npc.setUser((User)session.getAttribute("user"));
        }

        return npc;
    }

    /**
     * saves NPC in the session to the database
     * @param session   HttpSession
     */
    private void saveNPC(HttpSession session) {
        NPC npcToSave = (NPC)session.getAttribute("npc");
        GenericDao<NPC> npcDao = new GenericDao<>(NPC.class);
        // check if NPC is in database. If yes, update. If no, insert
        if (npcToSave.getId() != 0) {
            npcDao.update(npcToSave);
        } else {
            npcDao.insert(npcToSave);
        }
    }

    /**
     * Deletes npc in session from the database
     * @param session   HttpSession
     */
    private void deleteNPC(HttpSession session) {
        NPC npcToDelete = (NPC)session.getAttribute("npc");
        GenericDao<NPC> npcDao = new GenericDao<>(NPC.class);
        npcDao.delete(npcToDelete);
    }
}
