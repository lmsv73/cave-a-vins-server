package com.reference.api.repository;

import com.reference.api.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByName(String name);
}

