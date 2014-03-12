package com.truste.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "roles")
public class Role implements Serializable
{
    @Id
    @Column(nullable = false, unique = true)
    String role;

    public Role()
    {
    }

    public Role(String role)
    {
        this.role = role;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
