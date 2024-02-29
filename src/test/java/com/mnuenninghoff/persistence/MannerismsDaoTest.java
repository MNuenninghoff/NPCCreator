package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Mannerisms;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MannerismsDaoTest {

    GenericDao<Mannerisms> mannerismsDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        mannerismsDao = new GenericDao<>(Mannerisms.class);
    }

    @Test
    void getAll() {
        List<Mannerisms> mannerisms = mannerismsDao.getAll();
        assertEquals(20, mannerisms.size());
    }

    @Test
    void getById() {
        Mannerisms retrievedMannerisms = mannerismsDao.getById(7);
        assertEquals("Whispers", retrievedMannerisms.getMannerisms());
    }

    @Test
    void delete() {
        mannerismsDao.delete(mannerismsDao.getById(1));
        assertNull(mannerismsDao.getById(1));
    }

    @Test
    void insert() {
        Mannerisms newMannerism = new Mannerisms("Plucks eyebrows");
        mannerismsDao.insert(newMannerism);
        List<Mannerisms> mannerisms = mannerismsDao.getAll();
        assertEquals(21, mannerisms.size());
    }

    @Test
    void update() {
        Mannerisms retrievedMannerisms = mannerismsDao.getById(1);
        retrievedMannerisms.setMannerisms("Scratches armpits");
        mannerismsDao.update(retrievedMannerisms);
        Mannerisms updatedMannerisms = mannerismsDao.getById(1);
        assertEquals(retrievedMannerisms, updatedMannerisms);
    }
}