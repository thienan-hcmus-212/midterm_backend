package hcmus.web.midterm.service;

import hcmus.web.midterm.dao.RoleDao;
import hcmus.web.midterm.dao.UserDao;
import hcmus.web.midterm.entity.Role;
import hcmus.web.midterm.entity.User;
import hcmus.web.midterm.payload.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserEmail("admin@gmail.com");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserEmail("midterm@gmail.com");
        user.setUserPassword(getEncodedPassword("midterm@pass"));
        user.setUserFirstName("midterm");
        user.setUserLastName("Owner group");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);

        user.setUserEmail("midterm1@gmail.com");
        user.setUserPassword(getEncodedPassword("midterm1@pass"));
        user.setUserFirstName("midterm");
        user.setUserLastName("Co-owner group");
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);

        user.setUserEmail("midterm2@gmail.com");
        user.setUserPassword(getEncodedPassword("midterm2@pass"));
        user.setUserFirstName("midterm");
        user.setUserLastName("member group");
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);

        user.setUserEmail("midterm3@gmail.com");
        user.setUserPassword(getEncodedPassword("midterm3@pass"));
        user.setUserFirstName("midterm");
        user.setUserLastName("member group");
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public ResponseEntity<?> registerNewUser(User user) {

        Boolean isExisted = userDao.existsById(user.getUserEmail());

        if (isExisted){
            MessagePayload payload = new MessagePayload("email is existed");
            return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
        } else {
            Role role = roleDao.findById("User").get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRole(userRoles);
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));

            userDao.save(user);

            MessagePayload payload = new MessagePayload("ok");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public ResponseEntity<?> updateUserInfo(User user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userEmail = userDetails.getUsername();
        User userNew = userDao.findById(userEmail).get();


        if (user.getUserFirstName()!=null){
            userNew.setUserFirstName(user.getUserFirstName());
        }

        if (user.getUserLastName()!=null){
            userNew.setUserLastName(user.getUserLastName());
        }

        if (user.getUserPassword()!=null){
            userNew.setUserPassword(getEncodedPassword(user.getUserPassword()));
        }

        userDao.save(userNew);

        MessagePayload payload = new MessagePayload("ok");

        return new ResponseEntity<>(payload,HttpStatus.OK);
    }
}
