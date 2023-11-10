package com.example.customcourseplanner.model;

import com.example.customcourseplanner.jsonClasses.Link;
import com.example.customcourseplanner.model.enums.Level;
import com.example.customcourseplanner.model.enums.MaterialType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Objects;

@Entity(name = "material")
@Table(name = "material")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Material extends AbstractEntity {
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private MaterialType materialType;

    @JdbcTypeCode(SqlTypes.JSON)
    private Link links;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "materials")
    List<Course> courses;

    public Material(Job job, Level level, MaterialType materialType) {
        this.job = job;
        this.level = level;
        this.materialType = materialType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return Objects.equals(getId(), material.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Material{" +
                "level=" + level +
                ", links=" + links +
                '}';
    }
}
