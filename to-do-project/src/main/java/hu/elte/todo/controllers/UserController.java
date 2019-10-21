package hu.elte.todo.controllers;

import hu.elte.todo.entities.Task;
import hu.elte.todo.entities.User;
import hu.elte.todo.repositories.TaskRepository;
import hu.elte.todo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;  
    
    @Autowired
    private TaskRepository taskRepository;

    @Secured("ROLE_USER")
    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    
    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
    
    @Secured("ROLE_USER")
    @PutMapping("/{id}")
    public ResponseEntity<User> put(@RequestBody User user, @PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
    @Secured("ROLE_USER")
    @GetMapping("/{id}/tasks")
    public ResponseEntity<Iterable<Task>> tasks(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            return ResponseEntity.ok(oUser.get().getTasks());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/{id}/tasks")
    public ResponseEntity<Task> inserTask(@PathVariable Integer id, @RequestBody Task task) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();
            Task newTask = taskRepository.save(task);
            user.getTasks().add(newTask);
            userRepository.save(user);  // have to trigger from the @JoinTable side
            return ResponseEntity.ok(newTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }  
    
    
    @Secured("ROLE_USER")
    @PutMapping("/{id}/tasks")
    public ResponseEntity<Iterable<Task>> modifyTasks(@PathVariable Integer id, @RequestBody List<Task> tasks) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();

            // if we would like to add new labels as well
            for (Task task: tasks) {
                if (task.getId() == null) {
                    taskRepository.save(task);
                }
            }

            user.setTasks(tasks);
            userRepository.save(user);
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        Optional<User> oUser = userRepository.findByUsername(user.getUsername());
//        if (oUser.isPresent()) {
//            return ResponseEntity.badRequest().build();
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        user.setRole(User.Role.ROLE_USER);
//        return ResponseEntity.ok(userRepository.save(user));
//    }
//
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody User user) {
//        return ResponseEntity.ok().build();
//    } 
}
