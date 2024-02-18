package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.InteractionTraits;
import com.mnuenninghoff.util.Database;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteractionTraitsDaoTest {

    InteractionTraitsDao interactionTraitsDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        interactionTraitsDao = new InteractionTraitsDao();
    }

    @Test
    void getById() {
        InteractionTraits retrievedInteractionTraits = interactionTraitsDao.getById(1);
        assertNotNull(retrievedInteractionTraits);
        assertEquals("Argumentative", retrievedInteractionTraits.getInteractionTraits());
    }

    @Test
    void update() {
        InteractionTraits interactionTraits = interactionTraitsDao.getById(1);
        interactionTraits.setInteractionTraits("Solemn");
        interactionTraitsDao.update(interactionTraits);

        InteractionTraits retrievedInteractionTraits = interactionTraitsDao.getById(1);
        assertEquals("Solemn", retrievedInteractionTraits.getInteractionTraits());
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}