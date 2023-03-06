package com.example.hearus.Service;

import com.example.hearus.Entity.UserDetails;

import java.util.List;
import java.util.Optional;


public interface LoginRegisterService {
    public List<UserDetails> getUsers();

    public UserDetails  saveUser(UserDetails user);

    UserDetails authUser(UserDetails user);

//    Optional<UserDetails> addUser(UserDetails user);

    void Login();

    UserDetails getUserById(Long id);

    UserDetails update(Long id, UserDetails user);

    UserDetails saveUpdate(UserDetails user);
}
