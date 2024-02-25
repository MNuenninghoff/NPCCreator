package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.InteractionTraits;
import com.mnuenninghoff.entity.NPC;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NPCDaoTest {

    GenericDao npcDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump3.sql");
        npcDao = new GenericDao(NPC.class);
    }

    @Test
    void getAll() {
        List<NPC> npcs = npcDao.getAll();
        assertEquals(4, npcs.size());
    }

    @Test
    void getById() {
        NPC retrievedNPC = (NPC)npcDao.getById(4);
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
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void findByPropertyEqual() {
    }
}