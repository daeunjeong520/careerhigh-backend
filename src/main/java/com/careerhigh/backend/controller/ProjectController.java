package com.careerhigh.backend.controller;

import com.careerhigh.backend.persist.entity.Project;
import com.careerhigh.backend.service.ProjectService;
import com.careerhigh.backend.vo.request.ProjectApplyRequest;
import com.careerhigh.backend.vo.request.ProjectCreateRequest;
import com.careerhigh.backend.vo.request.ProjectCommissionRequest;
import com.careerhigh.backend.vo.request.ProjectDiscussionRequest;
import com.careerhigh.backend.vo.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // 프로젝트 등록
    @PostMapping("/api/projects")
    public ProjectCreateResponse createProject(@RequestBody ProjectCreateRequest request) {
        return ProjectCreateResponse.fromDto(
                projectService.registerProject(
                        request.getClientId(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getStartDate(),
                        request.getPeriod(),
                        request.getJobGroup(),
                        request.getJob(),
                        request.getWantCareerYear(),
                        request.getWorkStyle(),
                        request.getPay(),
                        request.getSkill())
        );
    }

    // 프로젝트 리스트 전체 조회
    @GetMapping("/api/clients/{clientId}/projects")
    public List<ProjectInfo> getProjects(@PathVariable("clientId") Long clientId, @RequestParam(name = "status") String status) {
        return projectService.getProjectList(clientId, status)
                .stream()
                .map(ProjectInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 프로젝트 상세 조회(생성한 프로젝트 상세 조회)
    @GetMapping("/api/projects/create/{projectId}")
    public ProjectCreateDetail getProjectCreateDetail(@PathVariable("projectId") Long projectId) {
        return ProjectCreateDetail.fromDto(projectService.getProject(projectId));
    }

    // 프로젝트 의뢰(클라이언트 -> 프리랜서)
    @PostMapping("/api/projects/commission")
    public ProjectCommissionResponse requestProject(@RequestBody ProjectCommissionRequest request) {
        return ProjectCommissionResponse.fromDto(
                projectService.commissionProject(
                        request.getProjectId(),
                        request.getFreelancerId()
                )
        );
    }

    // 클라이언트 -> 의뢰한 프리랜서 목록 조회
    @GetMapping("/api/projects/{projectId}/commission")
    public List<FreelancerInfo> commissionFreelancerList(@PathVariable("projectId") Long projectId) {
        return projectService.getCommissionFreelancerList(projectId)
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    // 프로젝트 지원(프리랜서 -> 클라이언트의 프로젝트)
    @PostMapping("/api/projects/apply")
    public ProjectApplyResponse applyProject(@RequestBody ProjectApplyRequest request) {
        return ProjectApplyResponse.fromDto(
                projectService.applyProject(
                        request.getFreelancerId(),
                        request.getProjectId()
                )
        );
    }

    // 클라이언트 -> 지원한 프리랜서 목록 조회
    @GetMapping("/api/projects/{projectId}/apply")
    public List<FreelancerInfo> applyFreelancerList(@PathVariable("projectId") Long projectId) {
        return projectService.getApplyFreelancerList(projectId)
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }

    //협의 희망 -> 프로젝트 상태: CREATE, 프리랜서-프로젝트 조회: 상태 => DISCUSSION 변경
    @PostMapping("/api/projects/discussion")
    public ProjectDiscussionResponse discussionProject(@RequestBody ProjectDiscussionRequest request) {
        return ProjectDiscussionResponse.fromDto(
                projectService.discussionProject(
                    request.getProjectId(),
                    request.getFreelancerId()
                )
        );
    }

    // TODO: 협의중인 프리랜서 리스트
    @GetMapping("/api/projects/{projectId}/discussion")
    public List<FreelancerInfo> getDiscussionFreelancerList(@PathVariable("projectId") Long projectId) {
        return projectService.getDiscussionFreelancerList(projectId)
                .stream()
                .map(FreelancerInfo::fromDto)
                .collect(Collectors.toList());
    }
}