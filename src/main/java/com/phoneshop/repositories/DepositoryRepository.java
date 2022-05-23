package com.phoneshop.repositories;

import com.phoneshop.entities.Depository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoryRepository extends JpaRepository<Depository, Long> {
}
