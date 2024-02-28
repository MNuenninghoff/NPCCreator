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
}