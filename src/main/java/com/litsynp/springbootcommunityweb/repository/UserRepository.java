package com.litsynp.springbootcommunityweb.repository;

import com.litsynp.springbootcommunityweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
