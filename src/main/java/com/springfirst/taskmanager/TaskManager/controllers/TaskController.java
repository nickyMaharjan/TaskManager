package com.springfirst.taskmanager.TaskManager.controllers;


import com.springfirst.taskmanager.TaskManager.DTO.CreateTaskDTO;
import com.springfirst.taskmanager.TaskManager.DTO.ErrorDTO;
import com.springfirst.taskmanager.TaskManager.DTO.UpdateTaskDTO;
import com.springfirst.taskmanager.TaskManager.entities.TaskEntity;
import com.springfirst.taskmanager.TaskManager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = service.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id")Integer id){
        var task = service.getTaskById(id);
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task= service.addTasks(body.getTitle(),body.getDescription(),body.getDeadline());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException {
        var task = service.updateTask(id, body.getDescription(), body.getDeadline(), body.getStatus());

        if(task == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleError(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorDTO("Invalid Date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorDTO("Internal Server Error"));
    }


}
