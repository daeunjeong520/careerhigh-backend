package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.entity.FreelancerProject;
import com.careerhigh.backend.persist.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreelancerProjectRepository extends JpaRepository<FreelancerProject, Long> {

    Optional<FreelancerProject> findByFreelancerAndProject(Freelancer freelancer, Project project);
}
