package com.reference.api.repository;

import com.reference.api.models.Bottle;
import com.reference.api.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BottleRepository  extends PagingAndSortingRepository<Bottle, Long> {
    List<Bottle> findByOwner(User u);
}
