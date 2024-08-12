package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}
