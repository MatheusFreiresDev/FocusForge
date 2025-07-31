package com.FocusForge.Repository;

import com.FocusForge.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<UserDetails> findByEmail (String email);
    public Optional<User> findUserByEmail(String email);

}
