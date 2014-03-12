package com.truste.app.dao;

import com.truste.app.config.PersistenceConfig;
import com.truste.app.domain.Role;
import com.truste.app.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void verifyRepo()
    {
        Assert.assertNotNull(userRepository);
        Assert.assertNotNull(roleRepo);

        final Role userRole = new Role("USER");
        roleRepo.save(userRole);

        User user = new User();
        user.setLastName("L");
        user.setFirstName("F");
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.getRoles().add(userRole);

        userRepository.save(user);
    }
}
