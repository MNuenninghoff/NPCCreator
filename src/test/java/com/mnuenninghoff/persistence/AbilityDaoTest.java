package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.Ability;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void getById() {
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