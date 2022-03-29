package com.example.project.data.repository;

import com.example.project.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.email = ?1")
    User findByEmail(String email);

    /*@Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    User getUserByUsername(@Param("username") String username);*/

}
