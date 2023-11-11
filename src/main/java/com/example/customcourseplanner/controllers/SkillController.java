package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Skill;
import com.example.customcourseplanner.service.SkillServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SkillController {
    private final SkillServiceImpl skillService;

    public SkillController(SkillServiceImpl skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public String showSkills(Model model) {
        List<Skill> skillList = skillService.getAllSkills();
        model.addAttribute("skillList", skillList);
        return "skills";
    }

    @GetMapping("/skills/{id}")
    public String showSkill(@PathVariable("id") long id, Model model) {
        Optional<Skill> skill = skillService.getSkillById(id);
        List<Skill> skillList = new ArrayList<>();
        skill.ifPresent(skillList::add);
        model.addAttribute("skillList", skillList);
        return "skills";
    }

    @GetMapping("/new_skill")
    public String addSkill() {
        return "/newSkill";
    }

    @PostMapping("/new_skill")
    public String skillPostAdd(@ModelAttribute Skill skill) {
        skillService.addSkill(skill);
        return "redirect:/skills";
    }

    @GetMapping("/skills/{id}/edit")
    public String editSkill(@PathVariable("id") long id, Model model) {
        Optional<Skill> skill = skillService.getSkillById(id);
        model.addAttribute("skill", skill);
        return "editSkill";
    }

    @PostMapping("/skills/{id}/edit")
    public String skillPostEdit(@PathVariable("id") long id, @ModelAttribute Skill updatedSkill) {
        skillService.editSkill(updatedSkill, id);
        return "redirect:/skills";
    }

    @PostMapping("/skills/{id}/delete")
    public String skillPostDelete(@PathVariable long id) {
        skillService.deleteSkillById(id);
        return "redirect:/skills";
    }
}
