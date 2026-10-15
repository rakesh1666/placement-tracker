package com.rakesh.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationRepository repo;

    public JobApplicationController(JobApplicationRepository repo) {
        this.repo = repo;
    }

    // 1. Saari applications dekho
    @GetMapping
    public List<JobApplication> getAll() {
        return repo.findAll();
    }

    // 2. Nayi application add karo
    @PostMapping
    public JobApplication add(@RequestBody JobApplication app) {
        return repo.save(app);
    }

    // 3. Status update karo (e.g. APPLIED -> INTERVIEW)
    @PutMapping("/{id}/status")
    public ResponseEntity<JobApplication> updateStatus(@PathVariable Long id,
                                                       @RequestParam String value) {
        return repo.findById(id).map(app -> {
            app.setStatus(value.toUpperCase());
            return ResponseEntity.ok(repo.save(app));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. Delete karo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 5. Summary: kis status mein kitni applications hain
    @GetMapping("/summary")
    public Map<String, Long> summary() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(JobApplication::getStatus, Collectors.counting()));
    }
}
