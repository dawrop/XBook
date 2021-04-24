package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.ERole;
import com.dawrop.XBook.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
