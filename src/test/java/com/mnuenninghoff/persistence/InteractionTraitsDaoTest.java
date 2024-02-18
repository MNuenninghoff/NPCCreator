package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.InteractionTraits;
import com.mnuenninghoff.util.Database;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        // create a new Interaction Trait
        InteractionTraits newTrait = new InteractionTraits("Tired");
        // insert into the database
        int id = interactionTraitsDao.insert(newTrait);
        // retrieve from database
        InteractionTraits retrievedTrait = interactionTraitsDao.getById(id);
        // check if the retrieved trait matches the inserted trait
        assertEquals(newTrait, retrievedTrait);
    }

    @Test
    void delete() {
        // delete interaction trait
        interactionTraitsDao.delete(interactionTraitsDao.getById(1));
        // verify that the deleted id is null
        assertNull(interactionTraitsDao.getById(1));
    }

    @Test
    void getAll() {
        // get all interaction traits
        List<InteractionTraits> allTraits = interactionTraitsDao.getAll();
        // verify that the size of the list is 11
        assertEquals(11, allTraits.size());
    }
}