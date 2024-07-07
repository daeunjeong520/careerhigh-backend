package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.FreelancerDto;
import com.careerhigh.backend.persist.repository.FreelancerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreelancerService {

    private final FreelancerRepository freelancerRepository;

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

    // 프리랜서 리스트 조회(인기 프리랜서)

    // 프리랜서 리스트 조회(추천 프리랜서)

    // 프리랜서 리스트 조회(직군)
    public List<FreelancerDto> searchFreelancersByJobGroup(String jobGroup) {
        return freelancerRepository.findByJobGroup(jobGroup)
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 프리랜서 리스트 조회(직무)
    public List<FreelancerDto> searchFreelancersByJob(String job) {
        return freelancerRepository.findByJob(job)
                .stream()
                .map(FreelancerDto::fromEntity)
                .collect(Collectors.toList());
    }
}
