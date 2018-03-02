package com.reference.api.repository;

import com.reference.api.models.Compartment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompartmentRepository extends PagingAndSortingRepository<Compartment, Long> {

}
