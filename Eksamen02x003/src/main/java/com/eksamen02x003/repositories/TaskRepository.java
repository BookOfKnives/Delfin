package com.eksamen02x003.repositories;

import com.eksamen02x003.models.Task;
import org.springframework.data.repository.CrudRepository;

import hans.westh.projectmanagement.models.Task;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TaskRepository extends CrudRepository<Task, Long> {

}
