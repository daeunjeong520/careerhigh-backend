package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.FreelancerDto;
import com.careerhigh.backend.dto.FreelancerProjectDto;
import com.careerhigh.backend.dto.ProjectDto;
import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.entity.FreelancerProject;
import com.careerhigh.backend.persist.entity.Project;
import com.careerhigh.backend.persist.repository.ClientRepository;
import com.careerhigh.backend.persist.repository.FreelancerProjectRepository;
import com.careerhigh.backend.persist.repository.FreelancerRepository;
import com.careerhigh.backend.persist.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ClientRepository clientRepository;
    private final FreelancerRepository freelancerRepository;
    private final ProjectRepository projectRepository;
    private final FreelancerProjectRepository freelancerProjectRepository;

    // 프로젝트 리스트 조회(status=CREATE, DISCUSSION, ONGOING, COMPLETE)
    public List<ProjectDto> getProjectList(Long clientId, String clientStatus) {
        // 클라이언트 조회
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Not found Client"));

        // 클라이언트의 프로젝트 전체 리스트 조회
        List<Project> projectList = client.getProjectList();
        List<ProjectDto> result = new ArrayList<>();

        for(Project project: projectList) {
            if(project.getClientStatus().equals(clientStatus)) {
                result.add(ProjectDto.fromEntity(project));
            }
        }
        return result;
    }

    // 프로젝트 상세 조회
    public ProjectDto getProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        return ProjectDto.fromEntity(project);
    }

    // 프로젝트 등록
    @Transactional
    public ProjectDto registerProject(
            Long clientId, String title, String description, String startDate, Integer period,
            String jobGroup, String job, Integer wantCareerYear, String workStyle, Integer pay, String skill) {

        log.info("============= create project ==================");

        // 클라이언트 조회
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Not found Client"));

        // 프로젝트 등록
        Project project = Project.builder()
                .client(client)
                .title(title)
                .description(description)
                .startDate(startDate)
                .period(period)
                .jobGroup(jobGroup)
                .job(job)
                .skill(skill)
                .wantCareerYear(wantCareerYear)
                .progress(0.0)
                .workStyle(workStyle)
                .pay(pay)
                .clientStatus("CREATE") // CREATE
                .build();

        return ProjectDto.fromEntity(projectRepository.save(project));
    }

    // 프로젝트 의뢰(클라이언트 -> 프리랜서 프로젝트 의뢰): COMMISSION
    @Transactional
    public FreelancerProjectDto commissionProject(Long projectId, Long freelancerId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프리랜서 조회
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        // 프리랜서-프로젝트 저장
        FreelancerProject freelancerProject = FreelancerProject.builder()
                .freelancer(freelancer)
                .project(project)
                .status("COMMISSION")
                .build();

        project.getFreelancerProjects().add(freelancerProject);
        FreelancerProject result = freelancerProjectRepository.save(freelancerProject);

        return FreelancerProjectDto.fromEntity(result);
    }

    // 의뢰한 프리랜서 리스트 조회(프로젝트의 의뢰한 프리랜서를 조회해야 함)
    public List<FreelancerDto> getCommissionFreelancerList(Long projectId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프로젝트에서 프리랜서 리스트 조회
        List<FreelancerDto> result = new ArrayList<>();
        List<FreelancerProject> freelancerProjects = project.getFreelancerProjects();

        for(FreelancerProject item: freelancerProjects) {
            if(item.getStatus().equals("COMMISSION")) {
                result.add(FreelancerDto.fromEntity(item.getFreelancer()));
            }
        }
        return result;
    }

    // 프로젝트 지원(프리랜서 -> 프로젝트) : APPLY
    @Transactional
    public FreelancerProjectDto applyProject(Long freelancerId, Long projectId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프리랜서 조회
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        // 프리랜서-프로젝트 저장
        FreelancerProject freelancerProject = FreelancerProject.builder()
                .project(project)
                .freelancer(freelancer)
                .status("APPLY")
                .build();

        FreelancerProject result = freelancerProjectRepository.save(freelancerProject);
        project.getFreelancerProjects().add(result);

        return FreelancerProjectDto.fromEntity(result);
    }

    // 지원한 프리랜서 리스트 조회: APPLY
    public List<FreelancerDto> getApplyFreelancerList(Long projectId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프로젝트에서 프리랜서 리스트 조회
        List<FreelancerDto> result = new ArrayList<>();
        List<FreelancerProject> freelancerProjects = project.getFreelancerProjects();

        for(FreelancerProject item: freelancerProjects) {
            if(item.getStatus().equals("APPLY")) {
                result.add(FreelancerDto.fromEntity(item.getFreelancer()));
            }
        }
        return result;
    }

    // 클라이언트 -> 지원한 프리랜서에 대해 협의 희망
    @Transactional
    public FreelancerProjectDto discussionProject(Long projectId, Long freelancerId) {
        // 프리랜서 조회
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프리랜서-프로젝트 조회
        FreelancerProject freelancerProject = freelancerProjectRepository.findByFreelancerAndProject(freelancer, project)
                .orElseThrow(() -> new RuntimeException("Not Found FreelancerProject"));

        freelancerProject.setStatus("DISCUSSION"); // CREATE-DISCUSSION

        return FreelancerProjectDto.fromEntity(freelancerProject);
    }

    // TODO: 협의중인 프리랜서 리스트 조회: DISCUSSION
    public List<FreelancerDto> getDiscussionFreelancerList(Long projectId) {
        // 프로젝트 조회
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Not Found Project"));

        // 프로젝트에서 프리랜서 리스트 조회(DISCUSSION)
        List<FreelancerDto> result = new ArrayList<>();
        List<FreelancerProject> freelancerProjects = project.getFreelancerProjects();

        for(FreelancerProject item: freelancerProjects) {
            if(item.getStatus().equals("DISCUSSION")) {
                result.add(FreelancerDto.fromEntity(item.getFreelancer()));
            }
        }
        return result;
    }

    // 프로젝트 삭제
    @Transactional
    public Long deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
        return projectId;
    }
}
