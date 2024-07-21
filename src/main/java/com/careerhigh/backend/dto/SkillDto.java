package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Skill;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDto {

    private Long skillId;
    private String name;
    private String link;
    private String proficiency; // beginner, intermediate, expert
    private String description;

    public static SkillDto fromEntity(Skill skill) {
        return SkillDto.builder()
                .skillId(skill.getSkillId())
                .name(skill.getName())
                .link(skill.getLink())
                .proficiency(skill.getProficiency())
                .description(skill.getDescription())
                .build();
    }
}
