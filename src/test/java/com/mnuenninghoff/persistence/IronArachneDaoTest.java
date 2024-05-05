package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Name;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IronArachneDaoTest {

    private IronArachneDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        dao = new IronArachneDao();
    }
    @Test
    void getMaleFirstName() {
        //male name
        Name maleName = dao.getName("dwarf", "male");
        logger.debug("Male Name valid race: " + maleName);
        assertEquals(1, maleName.getCount());
        assertEquals(1, maleName.getNames().size());
    }

    @Test
    void getMaleFirstNameInvalidRace() {
        Name maleName = dao.getName("aasimar", "male");
        logger.debug("Male Name invalid race: " + maleName);
        assertEquals(1, maleName.getCount());
        assertEquals(1, maleName.getNames().size());
    }

    @Test
    void getFemaleFirstName() {
        Name femaleName = dao.getName("dwarf", "female");
        logger.debug("Female Name : " + femaleName);
        assertEquals(1, femaleName.getCount());
        assertEquals(1, femaleName.getNames().size());
    }
    @Test
    void getFemaleFirstNameInvalidRace() {
        Name femaleName = dao.getName("aasimar", "female");
        logger.debug("female name invalid race: " + femaleName);
        assertEquals(1, femaleName.getCount());
        assertEquals(1, femaleName.getNames().size());
    }
    @Test
    void getFamilyNameInvalidRace() {
        Name familyName = dao.getName("aasimar", "family");
        logger.debug("Family name invalid race : " + familyName);
        assertEquals(1, familyName.getCount());
        assertEquals(1, familyName.getNames().size());
    }

    @Test
    void getFamilyName() {
        Name familyName = dao.getName("dwarf", "family");
        logger.debug("Family name: " + familyName);
        assertEquals(1, familyName.getCount());
        assertEquals(1, familyName.getNames().size());
    }
}