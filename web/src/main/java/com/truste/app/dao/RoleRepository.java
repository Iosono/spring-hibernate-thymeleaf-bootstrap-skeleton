package com.truste.app.dao;


import com.truste.app.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, String>
{

}
