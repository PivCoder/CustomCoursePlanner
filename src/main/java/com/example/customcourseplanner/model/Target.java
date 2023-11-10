package com.example.customcourseplanner.model;

import com.example.customcourseplanner.model.enums.Level;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity(name = "target")
@Table(name = "target")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Target extends AbstractEntity{
    @Column
    private String name;

    @Column
    private boolean isHardSkill;

    @Column
    private boolean isSoftSkill;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private boolean isArchived;

    @JsonBackReference
    @OneToMany(mappedBy = "target", fetch = FetchType.LAZY)
    private List<Skill> skillLists;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "targets")
    List<Job> jobs;

    public Target(String name, boolean isHardSkill, boolean isSoftSkill, Level level, boolean isArchived) {
        this.name = name;
        this.isHardSkill = isHardSkill;
        this.isSoftSkill = isSoftSkill;
        this.level = level;
        this.isArchived = isArchived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Target)) return false;
        Target target = (Target) o;
        return Objects.equals(getId(), target.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", isHardSkill=" + isHardSkill +
                ", isSoftSkill=" + isSoftSkill +
                ", level=" + level +
                ", isArchived=" + isArchived +
                '}';
    }
}
