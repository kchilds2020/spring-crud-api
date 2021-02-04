package com.example.demo.loginform;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse validateUser(LoginForm loginForm){
        UserResponse response = new UserResponse("success",null);

        Optional<User> user = userRepository.findUserByEmail(loginForm.getEmail());

        System.out.println(user.get().getPassword());
        System.out.println(loginForm.getPassword());


        if(!user.isPresent()){
            response.setMessage("incorrect email");
        }else{
            response.setUser(user.get());
        }

        if(!user.get().getPassword().equals(loginForm.getPassword())){
            response.setMessage("incorrect password");
            response.setUser(null);
        }

        return response;
    }
}
