package com.rakesh.tracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JobApplicationRepositoryTest {

    @Autowired
    private JobApplicationRepository repo;

    @Test
    void saveAndFindByStatus() {
        JobApplication app = new JobApplication();
        app.setCompany("TO THE NEW");
        app.setRole("Software Engineer");
        app.setStatus("TEST");
        repo.save(app);

        assertEquals(1, repo.findByStatus("TEST").size());
    }
}
