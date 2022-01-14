package uk.co.atlantis.rest.webservices.restfulwebservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.atlantis.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import uk.co.atlantis.rest.webservices.restfulwebservices.model.User;
import uk.co.atlantis.rest.webservices.restfulwebservices.services.UserDaoService;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userService;

    public UserController(UserDaoService userDaoService) {
        this.userService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retieveUser(@PathVariable int id) {
        User user = userService.findById( id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
    }
}
