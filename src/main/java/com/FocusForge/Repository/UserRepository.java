package com.FocusForge.Repository;

import com.FocusForge.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface UserRepository extends JpaRepository<User,Long> {
}
