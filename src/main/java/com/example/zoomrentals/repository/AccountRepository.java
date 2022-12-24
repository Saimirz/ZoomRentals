package com.example.zoomrentals.repository;

import com.example.zoomrentals.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account>findByRenterId(long id);
    void deleteByRenterId(long id);

}
