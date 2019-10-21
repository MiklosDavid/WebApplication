package hu.elte.todo.controllers;

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
import hu.elte.todo.repositories.DescriptionRepository;
import org.springframework.security.access.annotation.Secured;


@RestController
@RequestMapping("/descriptions")
public class DescriptionController {

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Secured("ROLE_USER")
    @GetMapping("")
    public ResponseEntity<Iterable<Description>> getAll() {
        return ResponseEntity.ok(descriptionRepository.findAll());
    }

    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public ResponseEntity<Description> get(@PathVariable Integer id) {
        Optional<Description> description = descriptionRepository.findById(id);
        if (description.isPresent()) {
            return ResponseEntity.ok(description.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("")
    public ResponseEntity<Description> post(@RequestBody Description description) {
        Description savedDescription = descriptionRepository.save(description);
        return ResponseEntity.ok(savedDescription);
    }

    @Secured("ROLE_USER")
    @PutMapping("/{id}")
    public ResponseEntity<Description> put(@RequestBody Description description, @PathVariable Integer id) {
        Optional<Description> oDescription = descriptionRepository.findById(id);
        if (oDescription.isPresent()) {
            description.setId(id);
            return ResponseEntity.ok(descriptionRepository.save(description));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Description> oDescription = descriptionRepository.findById(id);
        if (oDescription.isPresent()) {
            descriptionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
