package com.example.hearus.ServiceImpl;

import com.example.hearus.Entity.UserDetails;
import com.example.hearus.Repository.UserDetailsRepos;
import com.example.hearus.Service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    private UserDetailsRepos repos;

    @Autowired
    public LoginRegisterServiceImpl(UserDetailsRepos repos) {
        this.repos = repos;
    }

    @Override
    public List<UserDetails> getUsers() {
        return repos.findAll();
    }

    @Override
    public UserDetails saveUser(UserDetails user) {
        if(user != null
                && !repos.getUserDetailsByEmail(user.getEmail()).isPresent()){  //verify pre existing user
            repos.save(user);
            return user;
        }
        else { return null;
            }
    }

    @Override
    public UserDetails saveUpdate(UserDetails user) {
        return repos.save(user);
    }
    @Override
    public UserDetails authUser(UserDetails user) {

        UserDetails dbUser =
                repos.getUserDetailsByEmail(user.getEmail()).orElse(null);
        if (dbUser!= null) {
        if(user.getPassword()
                .equals(dbUser.getPassword())){
            return dbUser;
        }else {
            return null;
        }
        }else {
            return null;
        }
    }

    @Override
    public void Login() {

    }

    @Override
    public UserDetails getUserById(Long id) {
        return repos.findById(id).orElse(null);
    }

    @Override
    public UserDetails update(Long id, UserDetails user) {
        UserDetails oldUser = repos.findById(id).get();
        String relativeName,phoneNumber;
        relativeName = user.getRelativeName().toString();
        phoneNumber = user.getRelativeNo().toString();
        oldUser.setRelativeName(relativeName);
        oldUser.setRelativeNo(phoneNumber);
        System.out.println(oldUser.toString());
        return saveUpdate(oldUser);
    }


}
