package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Target;
import com.example.customcourseplanner.service.TargetServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class TargetRestController {
    private final TargetServiceImpl targetService;

    public TargetRestController(TargetServiceImpl targetService) {
        this.targetService = targetService;
    }

    @GetMapping("/targets")
    List<Target> getAll() {
        return targetService.getAllTargets();
    }
}
