package com.piotto.apiproduct.repositories;

import com.piotto.apiproduct.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {}
