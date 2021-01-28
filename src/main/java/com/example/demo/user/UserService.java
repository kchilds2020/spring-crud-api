package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        System.out.println(user);
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        System.out.println(exists);

        if(!exists){
            throw new IllegalStateException("student with id " + id + " does not exists");
        }

        userRepository.deleteById(id);

        return "user with id " + id + " has been deleted";
    }
    @Transactional
    public String updateUser(Long id, String firstname, String lastname, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("id does not exist"));

        if(firstname != null && firstname.length() > 0 && !Objects.equals(user.getFirstname(),firstname)){
            user.setFirstname(firstname);
        }

        if(lastname != null && lastname.length() > 0 && !Objects.equals(user.getLastname(), lastname)){
            user.setLastname(lastname);
        }

        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(),password)){
            user.setPassword(password);
        }

        return "User Updated";
    }
}
