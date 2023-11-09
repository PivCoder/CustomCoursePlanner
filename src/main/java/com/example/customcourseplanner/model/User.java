package com.example.customcourseplanner.model;

import com.example.customcourseplanner.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity(name = "login")
@Table(name = "login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Skill> skillLists;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @Column
    private boolean archived;

    public User(String name, String surname, Role role, User mentor, boolean archived) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.mentor = mentor;
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                ", mentor=" + mentor +
                ", archived=" + archived +
                '}';
    }
}
