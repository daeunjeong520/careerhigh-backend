package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
