package com.example.proyecto_final.exception;

public class TaskNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TaskNotFoundException(Integer id) {
        super("No se encontro la tarea con id: " + id);
    }
}
