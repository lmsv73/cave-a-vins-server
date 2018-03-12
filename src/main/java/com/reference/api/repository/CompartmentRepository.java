package com.reference.api.repository;

import com.reference.api.models.Compartment;
import com.reference.api.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CompartmentRepository extends PagingAndSortingRepository<Compartment, Long> {
    List<Compartment> findByOwner(User u);
}
