package com.phoneshop.repositories;


import com.phoneshop.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Boolean existsByUsername(String username);

}
