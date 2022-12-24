package com.example.zoomrentals.repository;

import com.example.zoomrentals.entity.Renter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Long> {

}
