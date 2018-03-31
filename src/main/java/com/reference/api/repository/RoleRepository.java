package com.reference.api.repository;

import com.reference.api.models.Role;
import com.reference.api.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByName(String name);
}

