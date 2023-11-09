package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Material;
import com.example.customcourseplanner.repositoryes.MaterialRepository;
import com.example.customcourseplanner.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteMaterialById(long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public Optional<Material> getMaterialById(long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material editMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }
}
