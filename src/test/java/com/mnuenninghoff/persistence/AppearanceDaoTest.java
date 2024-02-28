package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Appearance;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppearanceDaoTest {

    GenericDao<Appearance> appearanceDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB");
        appearanceDao = new GenericDao<>(Appearance.class);
    }

    @Test
    void getAll() {
        List<Appearance> appearances = appearanceDao.getAll();
        assertEquals(20, appearances.size());
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