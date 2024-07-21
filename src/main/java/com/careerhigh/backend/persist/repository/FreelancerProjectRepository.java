package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.FreelancerProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerProjectRepository extends JpaRepository<FreelancerProject, Long> {
}
