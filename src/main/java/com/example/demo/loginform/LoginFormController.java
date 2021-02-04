package com.example.demo.loginform;

import com.example.demo.user.User;
import com.example.demo.user.UserResponse;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/")
public class LoginFormController {
    /*LOGIN AND REGISTER APIS FOR USERS*/

    private LoginService loginService;

    @Autowired
    public LoginFormController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path = "login")
    public UserResponse loginUser(@RequestBody LoginForm loginForm){
        return loginService.validateUser(loginForm);
    }
}
