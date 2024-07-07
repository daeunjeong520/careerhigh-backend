package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

    @Query("SELECT f FROM Freelancer f WHERE f.jobGroup LIKE %:jobGroup%")
    List<Freelancer> findByJobGroup(@Param("jobGroup") String jobGroup);

    @Query("SELECT f FROM Freelancer f WHERE f.job LIKE %:job%")
    List<Freelancer> findByJob(@Param("job") String job);

    
}
