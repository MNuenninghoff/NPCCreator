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

    }

    @Test
    void delete() {
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