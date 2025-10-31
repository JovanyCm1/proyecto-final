package com.example.proyecto_final.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto_final.exception.TaskNotFoundException;
import com.example.proyecto_final.model.Task;
import com.example.proyecto_final.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(Task task) {
        // new entity: leave id as default (0) and let JPA generate value
        return repository.save(task);
    }

    public Task update(Integer id, Task updated) {
        return repository.findById(id).map(t -> {
            t.setTitulo(updated.getTitulo());
            t.setDescripcion(updated.getDescripcion());
            return repository.save(t);
        }).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void delete(Integer id) {
        if (!repository.existsById(id))
            throw new TaskNotFoundException(id);
        repository.deleteById(id);
    }
}
