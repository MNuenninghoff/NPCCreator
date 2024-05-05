package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Ability;
import com.mnuenninghoff.entity.InteractionTraits;
import com.mnuenninghoff.entity.NPC;
import com.mnuenninghoff.entity.User;
import com.mnuenninghoff.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NPCDaoTest {

    GenericDao npcDao;
    GenericDao interactionTraitsDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        npcDao = new GenericDao(NPC.class);
        interactionTraitsDao = new GenericDao(InteractionTraits.class);
    }

    @Test
    void getAll() {
        List<NPC> npcs = npcDao.getAll();
        assertEquals(4, npcs.size());
    }

    @Test
    void getById() {
        NPC retrievedNPC = (NPC) npcDao.getById(4);
        assertNotNull(retrievedNPC);
        assertEquals("Bryan", retrievedNPC.getName());
        assertEquals("bookseller", retrievedNPC.getDescription());
        assertEquals("Arrogant", retrievedNPC.getInteractionTraits().getInteractionTraits());
    }

    @Test
    void delete() {
        npcDao.delete(npcDao.getById(1));
        assertNull(npcDao.getById(1));
        List<NPC> npcs = npcDao.getAll();
        assertEquals(3, npcs.size());
    }

    @Test
    void deleteNPCbutTraitnotDeleted() {
        npcDao.delete(npcDao.getById(1));
        assertNull(npcDao.getById(1));
        List<NPC> npcs = npcDao.getAll();
        assertEquals(3, npcs.size());

        GenericDao<Ability> abilityDao = new GenericDao<>(Ability.class);
        assertNotNull(abilityDao.getById(1));
    }

    @Test
    void deleteUserAndNPCsDeleted() {
        GenericDao<User> userDao = new GenericDao<User>(User.class);
        userDao.delete(userDao.getById(1));

        //Check that NPC ids 3 and 4 are null (should have been deleted when their user was deleted)
        assertNull(npcDao.getById(3));
        assertNull(npcDao.getById(4));
    }

    @Test
    void insert() {
        // create a new npc
        NPC newNPC = new NPC();
        newNPC.setInteractionTraits((InteractionTraits) interactionTraitsDao.getById(1));
        newNPC.setDescription("armorer");
        newNPC.setName("Joseph");
        // insert the newly created npc
        int id = npcDao.insert(newNPC);
        // retrieve the newly created npc
        NPC retrievedNPC = (NPC) npcDao.getById(id);
        //confirm that the newly created npc equals the inserted npc
        assertEquals(newNPC, retrievedNPC);
    }

    @Test
    void update() {
        // retrieve a NPC
        NPC npcToUpdate = (NPC) npcDao.getById(1);
        // update the NPC
        npcToUpdate.setName("Bill");
        npcDao.update(npcToUpdate);
        // retrieve the updatedNPC
        NPC updatedNPC = (NPC) npcDao.getById(1);
        // confirm update happened
        assertEquals("Bill", updatedNPC.getName());
    }

    @Test
    void findByPropertyEqual() {
        List<NPC> results = npcDao.findByPropertyEqual("name", "Joey");
        assertEquals(0, results.size());
        results = npcDao.findByPropertyEqual("interactionTraits", interactionTraitsDao.getById(2));
        assertEquals(2, results.size());

        // Test searching with a Map<String, Object>
        Map<String, Object> searchCriteria = new HashMap<>();
        GenericDao<InteractionTraits> traitsDao = new GenericDao<>(InteractionTraits.class);
        GenericDao<Ability> abilityDao = new GenericDao<>(Ability.class);
        searchCriteria.put("interactionTraits", traitsDao.getById(2));
        searchCriteria.put("ability", abilityDao.getById(1));
        results = npcDao.findByPropertyEqual(searchCriteria);
        logger.debug("Search results (from Map): " + results);
        assertEquals(1, results.size());
    }
}