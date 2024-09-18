package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

    Optional<Freelancer> findByEmail(String email);

    // 인기 프리랜서 조회(평점 내림차순 정렬)
    List<Freelancer> findAllByOrderByStarRatingDesc();

    // 추천 프리랜서 조회(경력 내림차순 정렬)
    List<Freelancer> findAllByOrderByCareerYearDesc();

    // 키워드 검색 - 직군/직무 검색
    List<Freelancer> findByJobGroupContaining(String jobGroup);
    List<Freelancer> findByJobContaining(String job);
    List<Freelancer> findByJob(String job);
    List<Freelancer> findByJobGroup(String jobGroup);

    // 필터링 검색(직군/직무/근무방식)
    List<Freelancer> findAllByJobGroupAndJobAndWorkStyle(String jobGroup, String job, String workStyle);
}
