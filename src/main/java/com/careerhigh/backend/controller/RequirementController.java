package com.careerhigh.backend.controller;

import com.careerhigh.backend.service.RequirementService;
import com.careerhigh.backend.vo.request.RequirementCreateRequest;
import com.careerhigh.backend.vo.response.ProjectDashboardInfo;
import com.careerhigh.backend.vo.response.RequirementCreateResponse;
import com.careerhigh.backend.vo.response.RequirementInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RequirementController {

    private final RequirementService requirementService;

    // 프로젝트 대시보드 상세정보
    @GetMapping("/api/projects/dashboard")
    public ProjectDashboardInfo getProjectDashboardInfo(
            @RequestParam("projectId") Long projectId,
            @RequestParam("freelancerId") Long freelancerId
    ) {
        return requirementService.getProjectDashboardInfo(
                projectId,
                freelancerId
        );
    }

    // 클라이언트 - 요구사항 등록
    @PostMapping("/api/requirements")
    public RequirementCreateResponse createRequirement(
            @RequestBody RequirementCreateRequest request
    ) {
        return RequirementCreateResponse.fromDto(
                requirementService.createRequirement(
                        request.getProjectId(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getEndDate()
            )
        );
    }

    // 요구사항 전체 조회
    @GetMapping("/api/{projectId}/requirements")
    public List<RequirementInfo> getAllRequirements(@PathVariable("projectId") Long projectId) {
        return requirementService.getAllRequirements(projectId)
                .stream()
                .map(RequirementInfo::fromDto)
                .collect(Collectors.toList());
    }

    // TODO: 요구사항 상세 조회


}
