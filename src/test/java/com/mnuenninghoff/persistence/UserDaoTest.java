package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.User;
import com.mnuenninghoff.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao<User> userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new GenericDao<>(User.class);
    }

    @Test
    void getAll() {
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
    }

    @Test
    void getById() {
        User retrievedUser = userDao.getById(1);
        assertEquals("MichaelN", retrievedUser.getUserName());
    }

    @Test
    void delete() {
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void insert() {
        User newUser = new User();
        newUser.setUserName("newUser123");
        int id = userDao.insert(newUser);
        User retrievedUser = userDao.getById(id);
        assertEquals(newUser, retrievedUser);
    }

    @Test
    void update() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setUserName("alteredUser");
        userDao.update(userToUpdate);
        User updatedUser = userDao.getById(1);
        assertEquals(userToUpdate, updatedUser);
    }

    @Test
    void findByPropertyEqual() {
        List<User> results = userDao.findByPropertyEqual("userName", "MichaelN");
        assertEquals(1, results.size());
        results = userDao.findByPropertyEqual("userName", "Michael");
        assertEquals(0, results.size());
    }
}