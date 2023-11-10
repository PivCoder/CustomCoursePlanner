package com.example.customcourseplanner.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "task")
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends AbstractEntity {
    @Column
    private Date startDate;

    @Column
    private String name;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private Date endDate;

    @Column
    private String fileLink;

    @Column
    private boolean isDone;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tasks")
    List<User> users;

    public Task(Date startDate, String name, Date endDate, String fileLink, boolean isDone) {
        this.startDate = startDate;
        this.name = name;
        this.endDate = endDate;
        this.fileLink = fileLink;
        this.isDone = isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Task{" +
                "startDate=" + startDate +
                ", name='" + name + '\'' +
                ", endDate=" + endDate +
                ", fileLink='" + fileLink + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
