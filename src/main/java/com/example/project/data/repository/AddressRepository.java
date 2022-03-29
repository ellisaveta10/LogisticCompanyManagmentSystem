package com.example.project.data.repository;

import com.example.project.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByAddress(String name);
}
