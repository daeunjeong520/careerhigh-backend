package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "proficiency")
    private String proficiency; // beginner, intermediate, expert
}
