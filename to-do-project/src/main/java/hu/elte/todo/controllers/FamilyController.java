package hu.elte.todo.controllers;

import hu.elte.todo.entities.Family;
import hu.elte.todo.entities.User;
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
import hu.elte.todo.repositories.FamilyRepository;
import hu.elte.todo.repositories.UserRepository;
import org.springframework.security.access.annotation.Secured;


@RestController
@RequestMapping("/familys")
public class FamilyController {


    @Autowired
    private FamilyRepository familyRepository;  
    
    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public ResponseEntity<Iterable<Family>> getAll() {
        return ResponseEntity.ok(familyRepository.findAll());
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Family> get(@PathVariable Integer id) {
        Optional<Family> family = familyRepository.findById(id);
        if (family.isPresent()) {
            return ResponseEntity.ok(family.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("")
    public ResponseEntity<Family> post(@RequestBody Family family) {
        Family savedUser = familyRepository.save(family);
        return ResponseEntity.ok(savedUser);
    }
    
    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public ResponseEntity<Family> put(@RequestBody Family family, @PathVariable Integer id) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            family.setId(id);
            return ResponseEntity.ok(familyRepository.save(family));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            familyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}/users")
    public ResponseEntity<Iterable<User>> users(@PathVariable Integer id) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            return ResponseEntity.ok(oFamily.get().getUsers());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{id}/descriptions")
    public ResponseEntity<User> insertUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            Family family = oFamily.get();
            user.setFamily(family);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
        
        
    }
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private UserRepository familyRepository;
//
//    @PostMapping("register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        Optional<User> oUser = familyRepository.findByUsername(user.getUsername());
//        if (oUser.isPresent()) {
//            return ResponseEntity.badRequest().build();
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        user.setRole(User.Role.ROLE_USER);
//        return ResponseEntity.ok(familyRepository.save(user));
//    }
//
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody User user) {
//        return ResponseEntity.ok().build();
//    } 
