package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Skill;
import com.example.customcourseplanner.repositoryes.SkillRepository;
import com.example.customcourseplanner.service.api.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkillById(long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Optional<Skill> getSkillById(long id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill editSkill(Skill newSkill, long id) {
        return skillRepository.findById(id)
                .map(skill -> {
                    skill.setUser(newSkill.getUser());
                    skill.setTarget(newSkill.getTarget());
                    skill.setJob(newSkill.getJob());
                    skill.setLevel(newSkill.getLevel());
                    return skillRepository.save(skill);
                })
                .orElseGet(() -> skillRepository.save(newSkill));
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
