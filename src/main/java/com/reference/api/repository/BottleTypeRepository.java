package com.reference.api.repository;

import com.reference.api.models.BottleType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BottleTypeRepository extends PagingAndSortingRepository<BottleType, Long> {

    List<BottleType> findByValide(Boolean valide);

}