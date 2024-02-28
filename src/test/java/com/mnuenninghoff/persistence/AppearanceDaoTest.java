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
        database.runSQL("cleanDB.sql");
        appearanceDao = new GenericDao<>(Appearance.class);
    }

    @Test
    void getAll() {
        List<Appearance> appearances = appearanceDao.getAll();
        assertEquals(20, appearances.size());
    }

    @Test
    void getById() {
        Appearance retrievedAppearance = appearanceDao.getById(13);
        assertEquals("Bald", retrievedAppearance.getAppearance());
    }

    @Test
    void delete() {
        appearanceDao.delete(appearanceDao.getById(13));
        assertNull(appearanceDao.getById(13));
        List<Appearance> appearances = appearanceDao.getAll();
        assertEquals(19, appearances.size());
    }

    @Test
    void insert() {
        Appearance newAppearance = new Appearance("Large nostrils");
        int id = appearanceDao.insert(newAppearance);
        Appearance retrievedAppearance = appearanceDao.getById(id);
        assertEquals(newAppearance, retrievedAppearance);
    }

    @Test
    void update() {
        Appearance appearanceToChange = appearanceDao.getById(1);
        appearanceToChange.setAppearance("Purple Eyes");
        appearanceDao.update(appearanceToChange);
        Appearance retrievedAppearance = appearanceDao.getById(1);
        assertEquals(appearanceToChange, retrievedAppearance);
    }
}