package services;

import models.Task;
import models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    private Map<Integer, List<Task>> tasksByUser = new HashMap<>();
    private final UserService userService;

    public TaskService(UserService userService) {
        this.userService = userService;

        Task task1 = new Task(1, "Complete project documentation", false, 1);
        Task task2 = new Task(2, "Review PR #42", true, 2);
        Task task3 = new Task(3, "Update project dependencies", false, 3);

        tasksByUser.put(1, new ArrayList<>(List.of(task1, task2)));
        tasksByUser.put(2, new ArrayList<>(List.of(task3)));
        tasksByUser.put(3, new ArrayList<>(List.of(task1, task2, task3)));
    }

    // Retrieve all tasks for a specific user
    public List<Task> getTasksByUserId(int userId) {
        return tasksByUser.getOrDefault(userId, new ArrayList<>());
    }

    // Retrieve a specific task for a user
    public Optional<Task> getTaskById(int userId, int taskId) {
        List<Task> tasks = tasksByUser.get(userId);
        if (tasks != null) {
            return tasks.stream().filter(task -> task.getId() == taskId).findFirst();
        }
        return Optional.empty();
    }

    // Create a new task for a user
    public Task createTask(int userId, Task task) {
        tasksByUser.computeIfAbsent(userId, k -> new ArrayList<>()).add(task);
        return task;
    }

    // Update an existing task for a user
    public Task updateTask(int userId, int taskId, Task updatedTask) {
        List<Task> tasks = tasksByUser.get(userId);
        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getId() == taskId) {
                    task.setDescription(updatedTask.getDescription());
                    task.setCompleted(updatedTask.isCompleted());
                    return task;
                }
            }
        }
        throw new RuntimeException("Task not found");
    }

    // Delete a task for a user
    public void deleteTask(int userId, int taskId) {
        List<Task> tasks = tasksByUser.get(userId);
        if (tasks != null) {
            tasks.removeIf(task -> task.getId() == taskId);
        } else {
            throw new RuntimeException("Task not found for user: " + userId);
        }
    }
}
