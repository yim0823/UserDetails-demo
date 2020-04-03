package com.example.demo.api.repository;

import com.example.demo.api.domain.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insert_user() {

        String uid = UUID.randomUUID().toString();
        User newUser = User.builder()
                .uid(uid).password("1111").name("임태형B").roles(Collections.singletonList("ROLE_USER")).build();
        User savedUser = userRepository.save(newUser);
        Assert.assertThat(savedUser.getUid(), Matchers.is(uid));
    }
}