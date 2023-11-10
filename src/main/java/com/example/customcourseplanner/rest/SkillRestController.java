package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Skill;
import com.example.customcourseplanner.service.SkillServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SkillRestController {
    private final SkillServiceImpl skillService;

    SkillRestController(SkillServiceImpl skillService){
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    List<Skill> getAll() {
        return skillService.getAllSkills();
    }
}
