package uk.co.atlantis.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
        return userService.findOne(id);
    }
}
