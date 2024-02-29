package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Flaw;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlawDaoTest {

    GenericDao<Flaw> flawDao;

    @BeforeEach
    void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        flawDao = new GenericDao<>(Flaw.class);
    }

    @Test
    void getAll() {
        List<Flaw> flaws = flawDao.getAll();
        assertEquals(12, flaws.size());
    }

    @Test
    void getById() {
        Flaw retrievedFlaw = flawDao.getById(3);
        assertEquals("Arrogance", retrievedFlaw.getFlaw());
    }

    @Test
    void delete() {
        flawDao.delete(flawDao.getById(12));
        assertNull(flawDao.getById(12));
        List<Flaw> flaws = flawDao.getAll();
        assertEquals(11, flaws.size());
    }

    @Test
    void insert() {
        Flaw newFlaw = new Flaw("Obssesed by celebrity gossip");
        int id = flawDao.insert(newFlaw);
        Flaw retrievedFlaw = flawDao.getById(id);
        assertEquals(newFlaw, retrievedFlaw);
    }

    @Test
    void update() {
        Flaw retrievedFlaw = flawDao.getById(1);
        retrievedFlaw.setFlaw("Snores loudly");
        flawDao.update(retrievedFlaw);
        Flaw updatedFlaw = flawDao.getById(1);
        assertEquals(retrievedFlaw, updatedFlaw);
    }
}