package com.classpathio.ordersapplication.service;

import com.classpathio.ordersapplication.model.User;
import com.classpathio.ordersapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public Set<User> fetchUsers(){
        return Set.copyOf(this.userRepository.findAll());
    }

    public void delteUser(User user){
        this.userRepository.findById(user.getId()).ifPresent(this::delteUser);
    }
}
