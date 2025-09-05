package com.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin // for simple frontend testing; remove if not needed
public class EmployeeController {

  private final EmployeeRepository repo;

  public EmployeeController(EmployeeRepository repo) {
    this.repo = repo;
  }

  // CREATE
  @PostMapping
  public Employee create(@RequestBody Employee e) {
    return repo.save(e);
  }

  // READ: all
  @GetMapping
  public List<Employee> findAll() {
    return repo.findAll();
  }

  // READ: by id
  @GetMapping("/{id}")
  public ResponseEntity<Employee> findOne(@PathVariable Long id) {
    return repo.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // UPDATE (full update)
  @PutMapping("/{id}")
  public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee input) {
    return repo.findById(id).map(existing -> {
      existing.setFirstName(input.getFirstName());
      existing.setLastName(input.getLastName());
      existing.setEmail(input.getEmail());
      return ResponseEntity.ok(repo.save(existing));
    }).orElse(ResponseEntity.notFound().build());
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
