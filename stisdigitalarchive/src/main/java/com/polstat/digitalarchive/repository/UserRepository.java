package com.polstat.digitalarchive.repository;

import com.polstat.digitalarchive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long>{ public User findByEmail(String email);
}

