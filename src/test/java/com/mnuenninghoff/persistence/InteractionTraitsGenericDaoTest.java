package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.InteractionTraits;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InteractionTraitsGenericDaoTest {

    GenericDao genericInteractionTraitsDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        genericInteractionTraitsDao = new GenericDao(InteractionTraits.class);
    }

    @Test
    void getAll() {
        List<InteractionTraits> traits = genericInteractionTraitsDao.getAll();
        assertEquals(12, traits.size());
    }

    @Test
    void getById() {
        InteractionTraits retrievedTraits = (InteractionTraits)genericInteractionTraitsDao.getById(1);
        assertNotNull(retrievedTraits);
        assertEquals("Argumentative", retrievedTraits.getInteractionTraits());
        assertEquals(1, retrievedTraits.getId());
    }

    @Test
    void delete() {
        genericInteractionTraitsDao.delete(genericInteractionTraitsDao.getById(1));
        assertNull(genericInteractionTraitsDao.getById(1));
        List<InteractionTraits> traits = genericInteractionTraitsDao.getAll();
        assertEquals(11, traits.size());
    }

    @Test
    void insert() {
        // make new interactions trait
        InteractionTraits insertedTrait = new InteractionTraits("funny");

        // insert the order
        int id = genericInteractionTraitsDao.insert(insertedTrait);

        // retrieve the order
        InteractionTraits retrievedTrait = (InteractionTraits)genericInteractionTraitsDao.getById(id);
        // check if retrieved order equals inserted order
        assertEquals(insertedTrait, retrievedTrait);
    }

    @Test
    void update() {
        // retrieve InteractionTraits
        InteractionTraits interactionTraits = (InteractionTraits)genericInteractionTraitsDao.getById(4);

        // change retrieved InteractionTraits
        interactionTraits.setInteractionTraits("pizza-lover");

        // update InteractionsTrait
        genericInteractionTraitsDao.update(interactionTraits);
        InteractionTraits retrievedTraits = (InteractionTraits)genericInteractionTraitsDao.getById(4);

        // retrieve InteractionsTrait, confirm that it is updated as expected
        assertEquals("pizza-lover", retrievedTraits.getInteractionTraits());
    }

    @Test
    void findByPropertyEqual() {
        List<InteractionTraits> searchResults = genericInteractionTraitsDao.findByPropertyEqual("interactionTraits", "Friendly");
        assertEquals(1, searchResults.size());
        searchResults = genericInteractionTraitsDao.findByPropertyEqual("interactionTraits", "u");
        assertEquals(0, searchResults.size());
    }

    @Test
    void testFindByPropertyEqual() {
    }
}