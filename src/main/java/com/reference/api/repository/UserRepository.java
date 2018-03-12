package com.reference.api.repository;


import com.reference.api.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByUsernameAndPassword(String username, String password);
    User findOneByUsername (String username);
}
