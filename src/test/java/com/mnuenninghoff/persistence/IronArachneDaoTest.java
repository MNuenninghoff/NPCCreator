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
    void getFemaleFirstName() {
    }

    @Test
    void getFamilyName() {
    }
}