package com.edsoft.ToDoList.controllers;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.UserAndTask;
import com.edsoft.ToDoList.repository.TaskRepository;
import com.edsoft.ToDoList.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
@Tag(name = "Task Controller", description = "Task management APIs")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;


    @PostMapping("/addTaskToUser/{userName}")
    @Operation(summary = "Add Task By User", description = "Add a new task by User to system")
    public ResponseEntity addTaskToUser(@RequestBody Task task,
                                        @PathVariable String userName) {
      /*  if (!userValidation.existsUser(user)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("There is a user with the same id: " + user.getId() +
                            " or username: " + user.getName());
        }*/

        return ResponseEntity.ok(taskService.addTaskToUser(task, userName));
    }

    @GetMapping("/{userName}")
    @Operation(summary = "List All By User", description = "List all task by user")
    public ResponseEntity<List<Task>> getAllByUser(@PathVariable String userName,
                                                   @RequestParam(required = false) Status status) {
        List<Task> tasks;
        if (status != null) {
            tasks = taskService.getAllByUserAndStatus(userName, status);
        } else {
            tasks = taskService.getAllByUser(userName);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping
    @Operation(summary = "List All Task", description = "List all task")
    public ResponseEntity<List<UserAndTask>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @DeleteMapping("/{taskId}")
    @Operation(summary = "Delete Task By User", description = "Delete the task by user")
    public ResponseEntity delete(@PathVariable String taskId) {
        return ResponseEntity.ok(taskService.delete(taskId));
    }

    @PutMapping
    @Operation(summary = "Update User", description = "Update user")
    public ResponseEntity updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @PutMapping("/{taskId}/{taskStatus}")
    public ResponseEntity updateStatus(@PathVariable String taskId,
                                       @PathVariable Status taskStatus) {
        return ResponseEntity.ok(taskService.updateStatus(taskId,taskStatus));
    }
}
