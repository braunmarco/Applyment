package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "techology", schema = "public")
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String group;
    private String title;
    private String description;
    private String version;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "technologies")
    private Set<Project> projects = new HashSet<>();

    public Technology() {
    }

    public Technology(String group, String title, String description, String version) {
        this.group = group;
        this.title = title;
        this.description = description;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Technology technology = (Technology) o;

        return this.title.equals(technology.getTitle()) &&
                this.description.equals(technology.getDescription()) &&
                this.version.equals(technology.getVersion()) &&
                this.projects.equals(technology.getProjects());
    }

    @Override
    public int hashCode() {
        int hashCode = 9;

        return hashCode + 56 +
                title.hashCode() +
                description.hashCode() +
                version.hashCode() +
                projects.hashCode();
    }
}
