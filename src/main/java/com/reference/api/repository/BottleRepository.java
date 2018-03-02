package com.reference.api.repository;

import com.reference.api.models.Bottle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BottleRepository  extends PagingAndSortingRepository<Bottle, Long> {
}
