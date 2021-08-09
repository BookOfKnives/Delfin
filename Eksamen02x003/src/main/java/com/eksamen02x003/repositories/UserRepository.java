package com.eksamen02x003.repositories;

import com.eksamen02x003.models.User;
import org.springframework.data.repository.CrudRepository;

import hans.westh.projectmanagement.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

}
