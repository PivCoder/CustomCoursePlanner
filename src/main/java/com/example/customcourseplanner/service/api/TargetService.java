package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Target;

import java.util.List;
import java.util.Optional;

public interface TargetService {
    Target addTarget(Target target);
    void deleteTargetById(long id);
    Optional<Target> getTargetById(long id);
    Target editTarget(Target target, long id);
    List<Target> getAllTargets();
}
