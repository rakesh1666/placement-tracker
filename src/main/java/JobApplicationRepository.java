package com.rakesh.tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository se save, findAll, delete jaise methods free mil jaate hain
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(String status);
}
