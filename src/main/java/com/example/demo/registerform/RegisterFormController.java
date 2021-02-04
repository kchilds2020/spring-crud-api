package com.example.demo.registerform;

import com.example.demo.user.User;
import com.example.demo.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class RegisterFormController {

    private RegisterService registerService;

    @Autowired
    public RegisterFormController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(path = "register")
    public UserResponse createUser(@RequestBody User user){
        return registerService.createUser(user);
    }

}
