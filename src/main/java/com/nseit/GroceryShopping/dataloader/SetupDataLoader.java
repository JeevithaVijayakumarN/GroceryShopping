package com.nseit.GroceryShopping.dataloader;

import com.nseit.GroceryShopping.model.Role;
import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.repository.RoleRepository;
import com.nseit.GroceryShopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

//         Create user roles
        Role userRole = createRoleIfNotFound(Role.USER);
        Role adminRole = createRoleIfNotFound(Role.ADMIN);

        // Create users
        createUserIfNotFound("admin", adminRole);

        alreadySetup = true;
    }

    @Transactional
    private Role createRoleIfNotFound(final String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            role = roleRepository.save(role);
        }
        return role;
    }
    @Transactional
    private GroceryUser createUserIfNotFound(final String name, final Role role) {
        GroceryUser user = userRepository.findByUserName(name);
        if (user == null) {
            user = new GroceryUser(name,bCryptPasswordEncoder.encode("admin"));
            user.setRoles(Set.of(role));
            user = userRepository.save(user);
        }
        return user;
    }
}
