package com.eksamen02x001.demo.repository;

import com.eksamen02x001.demo.models.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TaskRepository extends CrudRepository<User, Long> {

}