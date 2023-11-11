package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Target;
import com.example.customcourseplanner.service.TargetServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TargetController {
    private final TargetServiceImpl targetService;

    public TargetController(TargetServiceImpl targetService) {
        this.targetService = targetService;
    }

    @GetMapping("/targets")
    public String showTargets(Model model) {
        List<Target> targetList = targetService.getAllTargets();
        model.addAttribute("targetList", targetList);
        return "targets";
    }

    @GetMapping("/targets/{id}")
    public String showTarget(@PathVariable("id") long id, Model model) {
        Optional<Target> target = targetService.getTargetById(id);
        List<Target> targetList = new ArrayList<>();
        target.ifPresent(targetList::add);
        model.addAttribute("targetList", targetList);
        return "targets";
    }

    @GetMapping("/new_target")
    public String addTarget(){
        return "/newTarget";
    }

    @PostMapping("/new_target")
    public String targetPostAdd(@RequestBody Target target) {
        targetService.addTarget(target);
        return "redirect:/targets";
    }

    @GetMapping("/targets/{id}/edit")
    public String editTarget(@PathVariable("id") long id, Model model) {
        Optional<Target> target = targetService.getTargetById(id);
        model.addAttribute("target", target.orElse(null));
        return "editTarget";
    }

    @PostMapping("/targets/{id}/edit")
    public String targetPostEdit(@PathVariable("id") long id, @ModelAttribute Target target) {
        targetService.editTarget(target, id);
        return "redirect:/targets";
    }

    @PostMapping("/targets/{id}/delete")
    public String targetPostDelete(@PathVariable long id) {
        targetService.deleteTargetById(id);
        return "redirect:/targets";
    }
}
