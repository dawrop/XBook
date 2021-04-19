package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);
    List<User> findByEmail(String email);
}
