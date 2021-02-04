package com.example.demo.user;

import com.example.demo.loginform.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "get-users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "register-user")
    public User registerNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @DeleteMapping(path = "delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping(path = "update-user/{userId}")
    public String updateUser(@PathVariable("userId") Long id,
                           @RequestParam(required = false) String firstname,
                           @RequestParam(required = false) String lastname,
                           @RequestParam(required = false) String password){
       return userService.updateUser(id, firstname, lastname, password);
    }

}
