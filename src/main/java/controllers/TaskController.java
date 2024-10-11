package controllers;

import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all tasks for a user
    @GetMapping
    public List<Task> getTasksByUserId(@PathVariable int userId) {
        return taskService.getTasksByUserId(userId);
    }

    // Get a specific task for a user
    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable int userId, @PathVariable int taskId) {
        Optional<Task> task = taskService.getTaskById(userId, taskId);
        if (task.isPresent()) {
            return task.get();
        }
        throw new RuntimeException("Task not found");
    }

    // Create a new task for a user
    @PostMapping
    public Task createTask(@PathVariable int userId, @RequestBody Task task) {
        return taskService.createTask(userId, task);
    }

    // Update a task for a user
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable int userId, @PathVariable int taskId, @RequestBody Task task) {
        return taskService.updateTask(userId, taskId, task);
    }

    // Delete a task for a user
    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable int userId, @PathVariable int taskId) {
        taskService.deleteTask(userId, taskId);
    }
}
