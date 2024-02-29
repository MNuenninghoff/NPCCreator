package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Talent;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TalentDaoTest {

    GenericDao<Talent> talentDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        talentDao = new GenericDao<>(Talent.class);
    }

    @Test
    void getAll() {
        List<Talent> talents = talentDao.getAll();
        assertEquals(20, talents.size());
    }

    @Test
    void getById() {
        Talent retrievedTalent = talentDao.getById(4);
        assertEquals("Perfect memory", retrievedTalent.getTalent());
    }

    @Test
    void delete() {
        talentDao.delete(talentDao.getById(1));
        assertNull(talentDao.getById(1));
    }

    @Test
    void insert() {
        Talent newTalent = new Talent("Expert Oddsmaker");
        int id = talentDao.insert(newTalent);
        Talent retrievedTalent = talentDao.getById(id);
        assertEquals(newTalent, retrievedTalent);
    }

    @Test
    void update() {
        Talent talentToUpdate = talentDao.getById(1);
        talentToUpdate.setTalent("Crochets expertly");
        talentDao.update(talentToUpdate);
        Talent retrievedTalent = talentDao.getById(1);
        assertEquals("Crochets expertly", retrievedTalent.getTalent());
    }
}