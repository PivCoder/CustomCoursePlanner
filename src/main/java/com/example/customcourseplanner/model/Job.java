package com.example.customcourseplanner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity(name = "job")
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job extends AbstractEntity{
    @Column
    private String name;

    @Column
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<Job> jobList;

    @JsonBackReference
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<User> userList;

    @JsonBackReference
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<Skill> skillLists;

    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return Objects.equals(getId(), job.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
