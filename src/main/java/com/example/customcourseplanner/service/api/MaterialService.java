package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    Material addMaterial(Material material);
    void deleteMaterialById(long id);
    Optional<Material> getMaterialById(long id);
    Material editMaterial(Material material);
    List<Material> getAllMaterials();
}
