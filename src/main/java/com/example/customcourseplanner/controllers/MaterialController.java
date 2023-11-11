package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Material;
import com.example.customcourseplanner.service.MaterialServiceImpl;
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
public class MaterialController {
    private final MaterialServiceImpl materialService;

    public MaterialController(MaterialServiceImpl materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/materials")
    public String showMaterials(Model model) {
        List<Material> materialList = materialService.getAllMaterials();
        model.addAttribute("materialList", materialList);
        return "materials";
    }

    @GetMapping("/materials/{id}")
    public String showMaterial(@PathVariable("id") long id, Model model) {
        Optional<Material> material = materialService.getMaterialById(id);
        List<Material> materialList = new ArrayList<>();
        material.ifPresent(materialList::add);
        model.addAttribute("materialList", materialList);
        return "materials";
    }

    @GetMapping("/new_material")
    public String addMaterial() {
        return "/newMaterial";
    }

    @PostMapping("/new_material")
    public String materialPostAdd(@ModelAttribute Material material) {
        materialService.addMaterial(material);
        return "redirect:/materials";
    }

    @GetMapping("/materials/{id}/edit")
    public String editMaterial(@PathVariable("id") long id, Model model) {
        Optional<Material> material = materialService.getMaterialById(id);
        model.addAttribute("material", material);
        return "editMaterial";
    }

    @PostMapping("/materials/{id}/edit")
    public String materialPostEdit(@PathVariable("id") long id, @ModelAttribute Material updatedMaterial) {
        materialService.editMaterial(updatedMaterial, id);
        return "redirect:/materials";
    }

    @PostMapping("/materials/{id}/delete")
    public String materialPostDelete(@PathVariable long id) {
        materialService.deleteMaterialById(id);
        return "redirect:/materials";
    }
}
