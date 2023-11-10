package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Material;
import com.example.customcourseplanner.service.MaterialServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MaterialRestController {
    private final MaterialServiceImpl materialService;

    MaterialRestController(MaterialServiceImpl materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/materials")
    List<Material> getAll() {
        return materialService.getAllMaterials();
    }
}
