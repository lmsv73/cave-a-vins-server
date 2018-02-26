package com.niran.reference.api.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BottleTypeRepository extends PagingAndSortingRepository<BottleType, Long> {

    List<BottleType> findByValide(Boolean valide);

}