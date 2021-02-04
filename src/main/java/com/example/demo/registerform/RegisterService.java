package com.example.demo.registerform;

import com.example.demo.loginform.LoginForm;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
   private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(User user){

        UserResponse userResponse = new UserResponse("success", null);
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()){
            userResponse.setMessage("email " + user.getEmail() + " already exists in our system.");
            return userResponse;
        }

        userResponse.setUser(userRepository.save(user));


        return userResponse;
    }
}
