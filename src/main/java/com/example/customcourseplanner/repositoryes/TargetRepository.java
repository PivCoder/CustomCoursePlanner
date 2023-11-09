package com.example.customcourseplanner.repositoryes;

import com.example.customcourseplanner.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {
}
