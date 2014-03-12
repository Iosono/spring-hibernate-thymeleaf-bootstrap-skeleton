package com.truste.app.dao;

import com.truste.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByEmail(String email);
}
