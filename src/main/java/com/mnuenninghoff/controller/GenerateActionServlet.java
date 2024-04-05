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
        switch (submit) {
            case "generateNPC":
                npc = generateNewNPC(session);
                // Add npc to the session
                session.setAttribute("npc", npc);
                // forward to editNPC.jsp
                forward(request, response, "editNPC.jsp");
                break;
            case "saveNPC":
                saveNPC(session);
                forward(request, response, "viewNPCdetails.jsp");
                break;
            case "deleteNPC":
                deleteNPC(session);
                forward(request, response, "index.jsp");
                break;
            case "updateDescription":
                String description = request.getParameter("description");
                updateDescription(session, description);
                forward(request, response, "editNPC.jsp");
                break;
            case "editNPC":
                forward(request, response, "editNPC.jsp");
                break;
            case "viewNPCs":
                forward(request, response, "viewNPCs.jsp");
            default:
                rerollAttribute(session, submit);
                forward(request, response, "editNPC.jsp");
        }
    }

    /**
     * updates the npc in the session given an attribute to update
     * @param session       HttpSession object
     * @param attribute     String selecting which attribute should be rerolled
     */
    private void rerollAttribute(HttpSession session, String attribute) {
        Random random = new Random();
        NPC npcToUpdate = (NPC)session.getAttribute("npc");

        // check what attribute needs to be rerolled
        logger.debug("rerollAttribute: " + attribute);
        switch(attribute) {
            case "rerollRace":
                npcToUpdate.setRace(rollRace(random));
                break;
            case "rerollName":
                npcToUpdate.setName(rollName(random, npcToUpdate.getRace()));
                break;
            case "rerollAbility":
                npcToUpdate.setAbility(rollAbility(random));
                break;
            case "rerollAppearance":
                npcToUpdate.setAppearance(rollAppearance(random));
                break;
            case "rerollBond":
                npcToUpdate.setBond(rollBond(random));
                break;
            case "rerollFlaw":
                npcToUpdate.setFlaw(rollFlaw(random));
                break;
            case "rerollInteractionTraits":
                npcToUpdate.setInteractionTraits(rollInteractionTraits(random));
                break;
            case "rerollMannerisms":
                npcToUpdate.setMannerisms(rollMannerisms(random));
                break;
            case "rerollTalent":
                npcToUpdate.setTalent(rollTalent(random));
                break;
        }
        session.setAttribute("npc", npcToUpdate);
    }
    private void updateDescription(HttpSession session, String description) {
        NPC npcToUpdate = (NPC)session.getAttribute("npc");
        npcToUpdate.setDescription(description);
        session.setAttribute("npc", npcToUpdate);
    }
    /**
     * forward to specified url
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param url           url to forward to
     * @throws ServletException ServletExcpetion
     * @throws IOException      IOException
     */
    private void forward(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * returns a random Ability
     * @param random    Random object
     * @return          Randomly selected Ability
     */
    private Ability rollAbility(Random random) {
        GenericDao<Ability> abilityDao = new GenericDao<>(Ability.class);
        List<Ability> abilities = abilityDao.getAll();
        Ability randomAbility = abilities.get(random.nextInt(abilities.size()));

        return randomAbility;
    }

    /**
     * returns a random appearance
     * @param random    Random object
     * @return          randomly selected Appearance
     */
    private Appearance rollAppearance(Random random) {
        GenericDao<Appearance> appearanceDao = new GenericDao<>(Appearance.class);
        List<Appearance> appearances = appearanceDao.getAll();
        Appearance randomAppearance = appearances.get(random.nextInt(appearances.size()));

        return randomAppearance;
    }

    /**
     * Returns a random Bond
     * @param random    Random object
     * @return          Randomly selected Bond
     */
    private Bond rollBond(Random random) {
        GenericDao<Bond> bondDao = new GenericDao<>(Bond.class);
        List<Bond> bonds = bondDao.getAll();
        Bond randomBond = bonds.get(random.nextInt(bonds.size()));

        return randomBond;
    }

    /**
     * Returns a randomly selected Flaw
     * @param random        Random object
     * @return              Randomly selected Flaw
     */
    private Flaw rollFlaw(Random random) {
        GenericDao<Flaw> flawDao = new GenericDao<>(Flaw.class);
        List<Flaw> flaws = flawDao.getAll();
        Flaw randomFlaw = flaws.get(random.nextInt(flaws.size()));

        return randomFlaw;
    }

    /**
     * Returns a randomly selected InteractionTraits
     * @param random    Random object
     * @return          Randomly selected InteractionTraits
     */
    private InteractionTraits rollInteractionTraits(Random random) {
        GenericDao<InteractionTraits> interactionTraitsDao = new GenericDao<>(InteractionTraits.class);
        List<InteractionTraits> interactionTraits = interactionTraitsDao.getAll();
        InteractionTraits randomInteractionTraits = interactionTraits.get(random.nextInt(interactionTraits.size()));

        return randomInteractionTraits;
    }

    /**
     * Returns a randomly selected Mannerisms
     * @param random        Random object
     * @return              Randomly selected Mannerisms
     */
    private Mannerisms rollMannerisms(Random random) {
        GenericDao<Mannerisms> mannerismsDao = new GenericDao<>(Mannerisms.class);
        List<Mannerisms> mannerisms = mannerismsDao.getAll();
        Mannerisms randomMannerism = mannerisms.get(random.nextInt(mannerisms.size()));

        return randomMannerism;
    }

    /**
     * Returns a randomly selected Race
     * @param random    Random object
     * @return          Randomly selected Race
     */
    private Race rollRace(Random random) {
        GenericDao<Race> raceDao = new GenericDao<>(Race.class);
        List<Race> races = raceDao.getAll();
        Race randomRace = races.get(random.nextInt(races.size()));

        return randomRace;
    }

    /**
     * returns a randomly generated name
     * @param random    Random object
     * @param race      Race of desired name
     * @return          String consisting of randomly generated first name + last name
     */
    private String rollName(Random random, Race race) {
        IronArachneDao nameGenerator = new IronArachneDao();
        Name firstName = null;
        // randomly pick male/female first name
        if (random.nextInt(2) == 0) {
            firstName = nameGenerator.getMaleFirstName(race.getRace());
        } else {
            firstName = nameGenerator.getFemaleFirstName(race.getRace());
        }
        Name lastName = nameGenerator.getFamilyName(race.getRace());
        String fullName = firstName.getNames().get(0) + " " + lastName.getNames().get(0);

        return fullName;
    }

    private Talent rollTalent(Random random) {
        GenericDao<Talent> talentDao = new GenericDao<>(Talent.class);
        List<Talent> talents = talentDao.getAll();
        Talent randomTalent = talents.get(random.nextInt(talents.size()));

        return randomTalent;
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
        npc.setAbility(rollAbility(random));
        // Appearance
        npc.setAppearance(rollAppearance(random));
        // Bond
        npc.setBond(rollBond(random));
        // Flaw
        npc.setFlaw(rollFlaw(random));
        // InteractionTraits
        npc.setInteractionTraits(rollInteractionTraits(random));
        // Mannerisms
        npc.setMannerisms(rollMannerisms(random));
        // Race
        npc.setRace(rollRace(random));
        // Name
        npc.setName(rollName(random, npc.getRace()));
        // Talent
        npc.setTalent(rollTalent(random));
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
