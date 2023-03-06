package com.example.hearus.Repository;

import com.example.hearus.Entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepos extends
        JpaRepository<UserDetails,Long> {

    Optional<UserDetails> getUserDetailsByEmail(String email);

}
