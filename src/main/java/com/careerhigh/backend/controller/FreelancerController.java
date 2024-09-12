package com.careerhigh.backend.controller;


import com.careerhigh.backend.dto.FreelancerDto;
import com.careerhigh.backend.service.FreelancerService;
import com.careerhigh.backend.vo.request.FreelancerLoginRequest;
import com.careerhigh.backend.vo.request.ProjectApplyRequest;
import com.careerhigh.backend.vo.response.FreelancerDetail;
import com.careerhigh.backend.vo.response.FreelancerInfo;
import com.careerhigh.backend.vo.response.FreelancerLoginResponse;
import com.careerhigh.backend.vo.response.ProjectApplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerService freelancerService;

    // 로그인(대충..)
    @PostMapping("/api/freelancers/login")
    public FreelancerLoginResponse login(@RequestBody FreelancerLoginRequest request) {
        return FreelancerLoginResponse.fromDto(
                freelancerService.login(request.getEmail(), request.getPassword())
        );
    }

    // 프리랜서 전체 조회
    @GetMapping("/api/freelancers")
    public List<FreelancerInfo> getAllFreelancers() {
        return freelancerService.getAllFreelancers()
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 프리랜서 상세 조회
    @GetMapping("/api/freelancers/{freelancerId}")
    public FreelancerDetail getFreelancer(@PathVariable("freelancerId") Long freelancerId) {
        return FreelancerDetail.fromDto(
                freelancerService.getFreelancer(freelancerId)
        );
    }

    // 프리랜서 조회 (직군/직무 검색)
    @GetMapping("/api/freelancers/search")
    public List<FreelancerInfo> searchFreelancersByJobGroupAndJob(@RequestParam("query") String query) {
        List<FreelancerInfo> searchResult = new ArrayList<>();

        query = query.replaceAll(" ", "");
        //List<FreelancerDto> searchByJobGroup = freelancerService.searchFreelancersByJobGroup(query);
        List<FreelancerDto> searchByJob = freelancerService.searchFreelancersByJob(query);

//        for(FreelancerDto f: searchByJobGroup) {
//            searchResult.add(FreelancerInfo.fromDto(f));
//        }

        for(FreelancerDto f: searchByJob) {
            searchResult.add(FreelancerInfo.fromDto(f));
        }

        return searchResult;
    }
}
