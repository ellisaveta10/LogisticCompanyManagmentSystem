package com.example.project.data.repository;

import com.example.project.data.entity.Roles;
import com.example.project.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    //Roles findByName(String name);
    @Query("SELECT r FROM Roles r where r.name = ?1")
    Roles findByName(String name);

    List<Roles> findAllByName(String name);
}
