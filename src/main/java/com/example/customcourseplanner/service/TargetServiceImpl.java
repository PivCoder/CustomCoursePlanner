package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Target;
import com.example.customcourseplanner.repositoryes.TargetRepository;
import com.example.customcourseplanner.service.api.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TargetServiceImpl implements TargetService {
    private final TargetRepository targetRepository;

    @Autowired
    public TargetServiceImpl(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    @Override
    public Target addTarget(Target target) {
        return targetRepository.save(target);
    }

    @Override
    public void deleteTargetById(long id) {
        targetRepository.deleteById(id);
    }

    @Override
    public Optional<Target> getTargetById(long id) {
        return targetRepository.findById(id);
    }

    @Override
    public Target editTarget(Target target) {
        return targetRepository.save(target);
    }

    @Override
    public List<Target> getAllTargets() {
        return targetRepository.findAll();
    }
}
