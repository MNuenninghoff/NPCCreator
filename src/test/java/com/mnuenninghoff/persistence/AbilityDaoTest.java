package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Ability;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbilityDaoTest {

    GenericDao abilityDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump4.sql");
        abilityDao = new GenericDao<>(Ability.class);
    }

    @Test
    void getAll() {
        List<Ability> abilities = abilityDao.getAll();
        assertEquals(11, abilities.size());
    }

    @Test
    void getById() {
        Ability retrievedAbility = (Ability)abilityDao.getById(1);
        assertNotNull(retrievedAbility);
        assertEquals("High Strength - powerful, brawny", retrievedAbility.getAbility());
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