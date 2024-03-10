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
        Name maleName = dao.getMaleFirstName("dwarf");
        logger.debug(maleName);
        assertEquals(1, maleName.getCount());
        assertEquals(1, maleName.getNames().size());
    }

    @Test
    void getMaleFirstNameInvalidRace() {
        Name maleName = dao.getMaleFirstName("aasimar");
        logger.debug(maleName);
        assertEquals(1, maleName.getCount());
        assertEquals(1, maleName.getNames().size());
    }

    @Test
    void getFemaleFirstName() {
        Name femaleName = dao.getFemaleFirstName("dwarf");
        logger.debug(femaleName);
        assertEquals(1, femaleName.getCount());
        assertEquals(1, femaleName.getNames().size());
    }

    @Test
    void getFamilyName() {
        Name familyName = dao.getFemaleFirstName("dwarf");
        logger.debug(familyName);
        assertEquals(1, familyName.getCount());
        assertEquals(1, familyName.getNames().size());
    }
}