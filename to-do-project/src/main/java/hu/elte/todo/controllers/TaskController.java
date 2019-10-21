package hu.elte.todo.controllers;

import hu.elte.todo.entities.Task;
import hu.elte.todo.entities.Description;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.todo.repositories.TaskRepository;
import hu.elte.todo.repositories.DescriptionRepository;
import java.util.List;
import org.springframework.security.access.annotation.Secured;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository; 
    
    @Autowired
    private DescriptionRepository descriptionRepository;

    @Secured("ROLE_USER")
    @GetMapping("")
    public ResponseEntity<Iterable<Task>> getAll() {
        return ResponseEntity.ok(taskRepository.findAll());
    }
    
    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("")
    public ResponseEntity<Task> post(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }
    
    @Secured("ROLE_USER")
    @PutMapping("/{id}")
    public ResponseEntity<Task> put(@RequestBody Task task, @PathVariable Integer id) {
        Optional<Task> oTask = taskRepository.findById(id);
        if (oTask.isPresent()) {
            task.setId(id);
            return ResponseEntity.ok(taskRepository.save(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Task> oTask = taskRepository.findById(id);
        if (oTask.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
    @Secured("ROLE_USER")
    @GetMapping("/{id}/descriptions")
    public ResponseEntity<Iterable<Description>> descriptions(@PathVariable Integer id) {
        Optional<Task> oTask = taskRepository.findById(id);
        if (oTask.isPresent()) {
            return ResponseEntity.ok(oTask.get().getDescriptions());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/{id}/descriptions")
    public ResponseEntity<Description> insertDescription(@PathVariable Integer id, @RequestBody Description description) {
        Optional<Task> oTask = taskRepository.findById(id);
        if (oTask.isPresent()) {
            Task task = oTask.get();
            description.setTask(task);
            return ResponseEntity.ok(descriptionRepository.save(description));
        } else {
            return ResponseEntity.notFound().build();
        }
    }  

}