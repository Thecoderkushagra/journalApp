package net.engineeringdigest.journalApp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.repository.UserRepository;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRoles(Arrays.asList("USER"));
        userRepository.save(users);
    }

    public void saveUser(Users users){userRepository.save(users);}

    public Users findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


    // ADMIN CALLS
    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public void saveAdminUser(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(users);
    }

}
