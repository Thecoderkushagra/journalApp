package net.engineeringdigest.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")


@Slf4j
public class AdminController {

    @Autowired
    public UserService userService;


    @GetMapping("/all-users")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> all = userService.getAll();
        if (!all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin")
    public ResponseEntity<Users> create(@RequestBody Users user){
        try {
            userService.saveAdminUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            log.error("error:",e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
