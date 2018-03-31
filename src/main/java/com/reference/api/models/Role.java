package com.reference.api.models;

import netscape.security.Privilege;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    private String name;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Collection<User> users;

}
