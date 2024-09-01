package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Project;
import com.careerhigh.backend.persist.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {

    List<Requirement> findByEndDateAndProject(LocalDate endDate, Project project);
}
