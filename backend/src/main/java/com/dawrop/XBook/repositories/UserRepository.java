package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findFirstByEmail(String email);
    boolean existsByEmail(String email);
}
