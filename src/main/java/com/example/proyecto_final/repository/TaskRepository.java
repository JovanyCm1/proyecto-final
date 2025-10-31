package com.example.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto_final.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
