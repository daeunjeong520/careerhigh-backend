package com.careerhigh.backend.controller;


import com.careerhigh.backend.service.FreelancerService;
import com.careerhigh.backend.vo.request.FreelancerLoginRequest;
import com.careerhigh.backend.vo.response.FreelancerDetail;
import com.careerhigh.backend.vo.response.FreelancerInfo;
import com.careerhigh.backend.vo.response.FreelancerLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerService freelancerService;

    // 로그인
    @PostMapping("/api/freelancers/login")
    public FreelancerLoginResponse login(@RequestBody FreelancerLoginRequest request) {
        return FreelancerLoginResponse.fromDto(
                freelancerService.login(request.getEmail(), request.getPassword())
        );
    }

    /**
     * 프리랜서 리스트 조회(전체/인기 프리랜서/추천 프리랜서)
     */
    // 프리랜서 전체 조회
    @GetMapping("/api/freelancers")
    public List<FreelancerInfo> getAllFreelancers() {
        return freelancerService.getAllFreelancers()
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 인기 프리랜서 조회(평점 순 정렬)
    @GetMapping("/api/freelancers/popular")
    public List<FreelancerInfo> getPopularFreelancers() {
        return freelancerService.getFreelancerSortedByStarRating()
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 추천 프리랜서 조회(경력 순 정렬)
    @GetMapping("/api/freelancers/recommend")
    public List<FreelancerInfo> getRecommendFreelancers() {
        return freelancerService.getFreelancerSortedByCareerYear()
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    /**
     * 프리랜서 단건 조회
     */
    @GetMapping("/api/freelancers/{freelancerId}")
    public FreelancerDetail getFreelancer(@PathVariable("freelancerId") Long freelancerId) {
        return FreelancerDetail.fromDto(
                freelancerService.getFreelancer(freelancerId)
        );
    }

    /**
     * 프리랜서 검색(필터링 검색/키워드 검색)
     */
    // 프리랜서 검색(필터링 검색-직군/직무/근무방식)
    @GetMapping("/api/freelancers/filter")
    public List<FreelancerInfo> filterSearch(@RequestParam("jobGroup") String jobGroup,
                                             @RequestParam("job") String job,
                                             @RequestParam("workStyle") String workStyle) {

        return freelancerService.filterSearch(jobGroup, job, workStyle)
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 프리랜서 검색(키워드 검색)
    @GetMapping("/api/freelancers/search")
    public List<FreelancerInfo> searchFreelancersByJobGroupAndJob(@RequestParam("query") String query) {
        return freelancerService.keywordSearch(query)
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }
}
