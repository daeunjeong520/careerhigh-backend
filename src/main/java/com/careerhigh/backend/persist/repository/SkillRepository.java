package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}