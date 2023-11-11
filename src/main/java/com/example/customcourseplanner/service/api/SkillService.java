package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    Skill addSkill(Skill skill);
    void deleteSkillById(long id);
    Optional<Skill> getSkillById(long id);
    Skill editSkill(Skill skill, long id);
    List<Skill> getAllSkills();
}
