package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Race;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceDaoTest {

    GenericDao<Race> raceDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        raceDao = new GenericDao<>(Race.class);
    }

    @Test
    void getAll() {
        List<Race> races = raceDao.getAll();
        assertEquals(14, races.size());
    }

    @Test
    void getById() {
        Race retrievedRace = raceDao.getById(1);
        assertEquals("Human", retrievedRace.getRace());
    }

    @Test
    void delete() {
        raceDao.delete(raceDao.getById(1));
        assertNull(raceDao.getById(1));
    }

    @Test
    void insert() {
        Race newRace = new Race();
        newRace.setRace("Orc");
        int id = raceDao.insert(newRace);
        Race retrievedRace = raceDao.getById(id);
        List<Race> races = raceDao.getAll();
        assertEquals(15, races.size());
    }

    @Test
    void update() {
        Race raceToUpdate = raceDao.getById(1);
        raceToUpdate.setRace("Orc");
        raceDao.update(raceToUpdate);
        Race retrievedRace = raceDao.getById(1);
        assertEquals(raceToUpdate, retrievedRace);
    }
}