package com.careerhigh.backend.controller;


import com.careerhigh.backend.dto.FreelancerDto;
import com.careerhigh.backend.service.FreelancerService;
import com.careerhigh.backend.vo.response.FreelancerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerService freelancerService;

    // 프리랜서 전체 조회
    @GetMapping("/api/freelancers")
    public List<FreelancerInfo> getAllFreelancers() {
        return freelancerService.getAllFreelancers()
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
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
