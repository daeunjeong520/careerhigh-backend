package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.FreelancerDto;
import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.repository.FreelancerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreelancerService {

    private final FreelancerRepository freelancerRepository;

    // 로그인
    @Transactional
    public FreelancerDto login(String email, String password) {
        Freelancer freelancer = freelancerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        if(!freelancer.getEncryptedPwd().equals(password)) {
            throw new RuntimeException("Not Match password");
        }
        return FreelancerDto.fromEntity(freelancer);
    }

    // 프리랜서 전체 조회
    public List<FreelancerDto> getAllFreelancers() {
        return freelancerRepository.findAll()
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 프리랜서 상세 조회
    public FreelancerDto getFreelancer(Long freelancerId) {
        return FreelancerDto.fromEntity(
                freelancerRepository.findById(freelancerId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found Freelancer"))
        );
    }

    // 프리랜서 리스트 조회(인기 프리랜서 - 평점 순 정렬)
    public List<FreelancerDto> getFreelancerSortedByStarRating() {
        return freelancerRepository.findAllByOrderByStarRatingDesc()
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 프리랜서 리스트 조회(추천 프리랜서 - 경력 순 정렬)
    public List<FreelancerDto> getFreelancerSortedByCareerYear() {
        return freelancerRepository.findAllByOrderByCareerYearDesc()
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * 프리랜서 검색(키워드 검색, 필터링 검색)
     */
    // 프리랜서 리스트 조회(키워드 검색)
    public List<FreelancerDto> keywordSearch(String keyword) {

        List<Freelancer> byJobGroupList = freelancerRepository.findByJobGroup(keyword);
        List<Freelancer> byJobList = freelancerRepository.findByJob(keyword);
        List<Freelancer> byJobGroupContainingList = freelancerRepository.findByJobGroupContaining(keyword);
        List<Freelancer> byJobContainingList = freelancerRepository.findByJobContaining(keyword);

        Set<Freelancer> result = new HashSet<>();
        result.addAll(byJobGroupList);
        result.addAll(byJobList);
        result.addAll(byJobGroupContainingList);
        result.addAll(byJobContainingList);

        return result.stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 프리랜서 - 필터링 검색(직군, 직무, 근무방식)
    public List<FreelancerDto> filterSearch(String jobGroup, String job, String workStyle) {
        return freelancerRepository.findAllByJobGroupAndJobAndWorkStyle(jobGroup, job, workStyle)
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }
}
