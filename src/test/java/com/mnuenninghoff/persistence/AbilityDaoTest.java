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
        database.runSQL("cleanDB.sql");
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
        //delete ability
        abilityDao.delete(abilityDao.getById(3));
        //try to retrieve, confirm null
        assertNull(abilityDao.getById(3));
        //confirm new size is 10
        List<Ability> abilities = abilityDao.getAll();
        assertEquals(10, abilities.size());
    }

    @Test
    void insert() {
        Ability newAbility = new Ability("Low Intelligence");
        int id = abilityDao.insert(newAbility);
        Ability retrievedAbility = (Ability)abilityDao.getById(id);
        assertEquals(newAbility, retrievedAbility);
    }

    @Test
    void update() {
        // retrieve ability
        Ability abilityToUpdate = (Ability)abilityDao.getById(1);
        // update ability
        abilityToUpdate.setAbility("Low Constitution");
        abilityDao.update(abilityToUpdate);
        // retrieve ability, confirm that it is updated as expected
        assertEquals(abilityToUpdate, abilityDao.getById(1));
    }
}