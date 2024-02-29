package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Bond;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BondDaoTest {

    GenericDao<Bond> bondDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        bondDao = new GenericDao<>(Bond.class);
    }

    @Test
    void getAll() {
        List<Bond> bonds = bondDao.getAll();
        assertEquals(9, bonds.size());
    }

    @Test
    void getById() {
        Bond retrievedBond = bondDao.getById(9);
        assertEquals("Out for revenge", retrievedBond.getBond());
    }

    @Test
    void delete() {
        bondDao.delete(bondDao.getById(9));
        assertNull(bondDao.getById(9));
    }

    @Test
    void insert() {
        Bond newBond = new Bond();
        newBond.setBond("Loves their pet");
        int id = bondDao.insert(newBond);
        Bond retrievedBond = bondDao.getById(id);
        assertEquals(newBond, retrievedBond);
    }

    @Test
    void update() {
        Bond bondToUpdate = bondDao.getById(9);
        bondToUpdate.setBond("Loves pet");
        bondDao.update(bondToUpdate);
        assertEquals(bondToUpdate, bondDao.getById(9));
    }
}