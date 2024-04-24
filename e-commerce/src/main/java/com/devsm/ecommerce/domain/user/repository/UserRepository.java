package com.devsm.ecommerce.domain.user.repository;

import com.devsm.ecommerce.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);


    Optional<User> findByEmail(String email);

}
