package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.RequirementDto;
import com.careerhigh.backend.persist.entity.*;
import com.careerhigh.backend.persist.repository.FreelancerRepository;
import com.careerhigh.backend.persist.repository.ProjectRepository;
import com.careerhigh.backend.persist.repository.RequirementRepository;
import com.careerhigh.backend.vo.response.ProjectDashboardInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequirementService {

    private final FreelancerRepository freelancerRepository;
    private final ProjectRepository projectRepository;
    private final RequirementRepository requirementRepository;

    // 프로젝트 대시보드 상세정보
    public ProjectDashboardInfo getProjectDashboardInfo(Long projectId, Long freelancerId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        Client client = project.getClient();

        // 전체 요구사항 & 완료한 요구사항
        List<Requirement> requirements = project.getRequirements();
        Integer totalRequirementNum = requirements.size();
        Integer completeRequirementNum = 0;

        for(Requirement item: requirements) {
            if(item.isCompleted()) {
                completeRequirementNum++;
            }
        }

        // 진행률 계산
        Double progress = 0.0;
        if(totalRequirementNum != 0) {
            progress = (double)completeRequirementNum / totalRequirementNum * 100;
        }

        // D-Day 계산
        LocalDate startDate = LocalDate.now(); // 현재 날짜 기준
        LocalDate endDate = project.getEndDate();
        Long dDay = ChronoUnit.DAYS.between(startDate, endDate);

        return ProjectDashboardInfo.builder()
                .projectId(projectId)
                .projectTitle(project.getTitle())
                .companyName(client.getCompanyName())
                .freelancerName(freelancer.getName())
                .progress(progress)
                .startDate(startDate.toString())
                .endDate(endDate.toString())
                .totalRequirement(totalRequirementNum)
                .completeRequirement(completeRequirementNum)
                .leftDate(dDay)
                .build();
    }

    // 요구사항 등록
    @Transactional
    public RequirementDto createRequirement(Long projectId, String title, String description, String endDate, String comment) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 요구사항 생성 및 등록
        Requirement requirement = Requirement.builder()
                .project(project)
                .title(title)
                .description(description)
                .endDate(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE))
                .isCompleted(false)
                .comment(comment)
                .build();

        List<Requirement> requirements = project.getRequirements();
        requirements.add(requirement);

        requirementRepository.save(requirement);

        return RequirementDto.fromEntity(requirement);
    }

    // 요구사항 전체 리스트
    public List<RequirementDto> getAllRequirements(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        return project.getRequirements()
                .stream()
                .map(RequirementDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 요구사항 상세
    public RequirementDto getRequirement(Long requirementId) {
        Requirement requirement = requirementRepository.findById(requirementId)
                .orElseThrow(() -> new RuntimeException("Not Found Requirement"));

        return RequirementDto.fromEntity(requirement);
    }

    // 요구사항 수정
    @Transactional
    public RequirementDto updateRequirement(Long requirementId, String title, String description, String endDate, String comment) {
        Requirement requirement = requirementRepository.findById(requirementId)
                .orElseThrow(() -> new RuntimeException("Not Found Requirement"));

        requirement.setTitle(title);
        requirement.setDescription(description);
        requirement.setEndDate(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE));
        requirement.setComment(comment);

        Requirement updatedRequirement = requirementRepository.save(requirement);

        return RequirementDto.fromEntity(updatedRequirement);
    }

    // 요구사항 완료
    @Transactional
    public RequirementDto completeRequirement(Long requirementId) {
        Requirement requirement = requirementRepository.findById(requirementId)
                .orElseThrow(() -> new RuntimeException("Not Found Requirement"));

        requirement.setCompleted(true);

        requirementRepository.flush();

        Requirement changedRequirement = requirementRepository.findById(requirementId)
                .orElseThrow(() -> new RuntimeException("Not Found Requirement"));

        return RequirementDto.fromEntity(changedRequirement);
    }

    // 요구사항 리스트 반환 (마감일 기준으로)
    public List<RequirementDto> getRequirementsByEndDate(Long projectId, String year, String month, String date) {

        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 마감일
        LocalDate endDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));

        return requirementRepository.findByEndDateAndProject(endDate, project)
                .stream()
                .map(RequirementDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 요구사항 마감일 텍스트 리스트 반환
    public List<String> getRequirementsEndDateText(Long projectId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        List<Requirement> requirements = project.getRequirements();
        List<String> result = new ArrayList<>();

        for(Requirement item: requirements) {
            result.add(item.getEndDate().toString());
        }

        return result;
    }
}
