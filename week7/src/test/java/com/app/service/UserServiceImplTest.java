package com.app.service;

import com.app.model.Factory;
import com.app.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private User u;

    @Before
    public void setUp() {
        u = new User();
        u.setFirstName("Alex");
        u.setLastName("Rashford");
        u.setFactories(Collections.<Factory>emptyList());
    }

    @Test
    public void testFindAll() {
        userService.add(u);
        u.setFirstName("TEST1_NAME");
        u.setLastName("TEST1_LAST_NAME");
        userService.update(u);

        List<User> users1 = userService.findAll();


        Optional<User> neededUser = users1
                .stream()
                .filter(el -> el.getFirstName().equals(u.getFirstName()) && el.getLastName().equals(u.getLastName()))
                .findAny();

        Assert.assertTrue(neededUser.isPresent());
    }
}